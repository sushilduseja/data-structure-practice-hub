package apple;

import java.util.*;

public class UniqueElementChecker {
    public boolean uniqueOccurrences(int[] arr) {
        // Step 1: Count frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Check if all frequencies are unique
        Set<Integer> frequencySet = new HashSet<>();
        for (int frequency : frequencyMap.values()) {
            if (!frequencySet.add(frequency)) {
                System.out.println(frequencySet + " " + frequencyMap);
                return false; // Duplicate frequency found
            }
        }
        System.out.println(frequencySet + " " + frequencyMap);
        return true;
    }
    
    // Test method for verification
    static public void runTests() {
        UniqueElementChecker uniqueElementChecker = new UniqueElementChecker();
        
        // Test Case 1
        int[] test1 = {1,2,2,1,1,3};
        boolean result1 = uniqueElementChecker.uniqueOccurrences(test1);
        System.out.println("Test 1: " + (result1 == true ? "PASS" : "FAIL"));
        
        // Test Case 2
        int[] test2 = {1,2};
        boolean result2 = uniqueElementChecker.uniqueOccurrences(test2);
        System.out.println("Test 2: " + (result2 == false ? "PASS" : "FAIL"));
        
        // Test Case 3
        int[] test3 = {-3,0,1,-3,1,1,1,-3,10,0};
        boolean result3 = uniqueElementChecker.uniqueOccurrences(test3);
        System.out.println("Test 3: " + (result3 == true ? "PASS" : "FAIL"));
        
        // Test Case 4
        int[] test4 = {1};
        boolean result4 = uniqueElementChecker.uniqueOccurrences(test4);
        System.out.println("Test 4: " + (result4 == true ? "PASS" : "FAIL"));
        
        // Test Case 5
        int[] test5 = {1,1,1,1};
        boolean result5 = uniqueElementChecker.uniqueOccurrences(test5);
        System.out.println("Test 5: " + (result5 == true ? "PASS" : "FAIL"));
        
        // Test Case 6
        int[] test6 = {1,2,3,1,2,3};
        boolean result6 = uniqueElementChecker.uniqueOccurrences(test6);
        System.out.println("Test 6: " + (result6 == false ? "PASS" : "FAIL"));
    }

    public static void main(String[] args) {
        runTests();
    }
}