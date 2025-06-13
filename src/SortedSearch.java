/**
 * Sorted Array Search Implementations
 *
 * This class demonstrates different approaches to counting numbers less than
 * a given value in a sorted array, showcasing the trade-off between
 * implementation simplicity and performance.
 *
 * Problem: Given a sorted array and a number, count how many numbers in the array
 * are less than the given number.
 */
public class SortedSearch {
    /**
     * Linear search implementation - Simple but O(n)
     * Suitable for small arrays or when simplicity is preferred
     */
    public static int countNumbersLinear(int[] sortedArray, int lessThan) {
        // Edge cases
        if (sortedArray == null || sortedArray.length == 0) return 0;
        if (lessThan <= sortedArray[0]) return 0;
        if (lessThan > sortedArray[sortedArray.length - 1]) return sortedArray.length;

        int count = 0;
        for (int num : sortedArray) {
            if (num < lessThan) count++;
            else break;  // Early exit since array is sorted
        }
        return count;
    }

    /**
     * Binary search implementation - Optimized O(log n)
     * Suitable for large sorted arrays where performance is critical
     */
    public static int countNumbersBinary(int[] sortedArray, int lessThan) {
        if (sortedArray == null || sortedArray.length == 0) return 0;
        if (lessThan <= sortedArray[0]) return 0;
        if (lessThan > sortedArray[sortedArray.length - 1]) return sortedArray.length;

        int left = 0;
        int right = sortedArray.length - 1;

        // Find the insertion point
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (sortedArray[mid] < lessThan) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left + 1;  // Add 1 because we want count of numbers less than
    }

    public static void main(String[] args) {
        // Test cases to compare both implementations
        int[][] testArrays = {
            {1, 3, 5, 7},      // Regular case
            {1, 2, 3, 4, 5},   // Sequential numbers
            {1},               // Single element
            {1, 1, 1, 2, 2},  // Duplicates
            {-3, -2, -1, 0}   // Negative numbers
        };

        int[] testValues = {4, 10, 0, 1, 2, -2};

        for (int[] arr : testArrays) {
            System.out.println("\nTesting array: " + java.util.Arrays.toString(arr));
            for (int val : testValues) {
                int linearResult = countNumbersLinear(arr, val);
                int binaryResult = countNumbersBinary(arr, val);
                System.out.printf("Value %d: Linear = %d, Binary = %d%n",
                                val, linearResult, binaryResult);
                assert linearResult == binaryResult :
                    "Implementation mismatch for value " + val;
            }
        }
    }
}
