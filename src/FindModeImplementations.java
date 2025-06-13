/**
 * Mode Finding Algorithm Implementations
 *
 * This file demonstrates different approaches to finding the mode (most frequent elements)
 * in a list of integers, showcasing various Java programming paradigms and features.
 *
 * Problem: Given a list of integers, find all numbers that appear with maximum frequency.
 *
 * Time Complexity for all implementations: O(n) where n is the size of input list
 * Space Complexity for all implementations: O(k) where k is the number of unique elements
 */

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindModeImplementations {

    /**
     * Implementation 1: Basic HashMap approach
     * Demonstrates fundamental use of HashMap for counting
     */
    public static List<Integer> findModeBasic(List<Integer> input) {
        if (input.isEmpty()) return new ArrayList<>();

        Map<Integer, Integer> count = new HashMap<>();
        // Count frequencies
        for (Integer val : input) {
            count.put(val, count.getOrDefault(val, 0) + 1);
        }

        // Find maximum frequency
        int maxCount = count.values().stream()
                           .mapToInt(Integer::intValue)
                           .max()
                           .orElse(0);

        // Collect all numbers with maximum frequency
        return count.entrySet().stream()
                   .filter(e -> e.getValue() == maxCount)
                   .map(Map.Entry::getKey)
                   .sorted()
                   .collect(Collectors.toList());
    }

    /**
     * Implementation 2: Using Java 8 merge operation
     * Demonstrates more concise frequency counting using merge
     */
    public static List<Integer> findModeMerge(List<Integer> input) {
        if (input.isEmpty()) return new ArrayList<>();

        Map<Integer, Integer> count = new HashMap<>();
        input.forEach(i -> count.merge(i, 1, Integer::sum));

        int maxFreq = Collections.max(count.values());
        return count.entrySet().stream()
                   .filter(e -> e.getValue() == maxFreq)
                   .map(Map.Entry::getKey)
                   .sorted()
                   .collect(Collectors.toList());
    }

    /**
     * Implementation 3: Full Stream API approach
     * Demonstrates functional programming style using Java streams
     */
    public static List<Integer> findModeStream(List<Integer> input) {
        Map<Integer, Long> countMap = input.stream()
                .collect(Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()
                ));

        if (countMap.isEmpty()) return new ArrayList<>();

        Long maxFreq = countMap.values().stream()
                              .max(Long::compare)
                              .get();

        return countMap.entrySet().stream()
                      .filter(e -> e.getValue().equals(maxFreq))
                      .map(Map.Entry::getKey)
                      .sorted()
                      .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // Test cases to verify all implementations produce the same results
        List<List<Integer>> testCases = Arrays.asList(
            Arrays.asList(1, 3, 2, 4, 1),          // Single mode: [1]
            Arrays.asList(1, 2, 4, 3, 1, 2),       // Multiple modes: [1, 2]
            Arrays.asList(1, 3, 2, 4),             // All frequencies equal: [1, 2, 3, 4]
            Arrays.asList(9, 9, 8, 8),             // Two modes: [8, 9]
            Arrays.asList(9, 9, 9, 8, 8),          // Single mode with higher frequency: [9]
            Arrays.asList()                         // Empty list: []
        );

        for (List<Integer> test : testCases) {
            System.out.println("\nTest case: " + test);
            System.out.println("Basic:  " + findModeBasic(test));
            System.out.println("Merge:  " + findModeMerge(test));
            System.out.println("Stream: " + findModeStream(test));
        }
    }
}
