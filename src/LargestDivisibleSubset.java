/**
 * Largest Divisible Subset Problem Implementation
 *
 * Problem Source: LeetCode Problem #368
 * Original Problem: https://leetcode.com/problems/largest-divisible-subset/
 *
 * This implementation finds the largest subset where for every pair (i, j),
 * nums[i] % nums[j] == 0 or nums[j] % nums[i] == 0.
 *
 * Time Complexity: O(n²) where n is the length of the input array
 * Space Complexity: O(n)
 */

import java.util.*;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        Arrays.sort(nums);  // Sort the array first
        int n = nums.length;

        // dp[i] stores the length of largest subset ending at index i
        int[] dp = new int[n];
        // prev[i] stores the previous index in the subset
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxLen = 1;  // Length of largest subset
        int maxIdx = 0;  // Index where largest subset ends

        // Build dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }

        // Reconstruct the subset
        List<Integer> result = new ArrayList<>();
        while (maxIdx != -1) {
            result.add(nums[maxIdx]);
            maxIdx = prev[maxIdx];
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        LargestDivisibleSubset solution = new LargestDivisibleSubset();

        // Test cases
        int[] nums1 = {1, 2, 3};
        System.out.println("Test Case 1: " + solution.largestDivisibleSubset(nums1));  // Expected: [1, 2]

        int[] nums2 = {1, 2, 4, 8};
        System.out.println("Test Case 2: " + solution.largestDivisibleSubset(nums2));  // Expected: [1, 2, 4, 8]

        int[] nums3 = {3, 4, 16, 8};
        System.out.println("Test Case 3: " + solution.largestDivisibleSubset(nums3));  // Expected: [4, 8, 16]
    }
}
