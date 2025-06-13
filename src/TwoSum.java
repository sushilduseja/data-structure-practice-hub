/**
 * Two Sum Problem Implementation
 *
 * Problem Source: LeetCode Problem #1
 * Original Problem: https://leetcode.com/problems/two-sum/
 *
 * This is a fundamental algorithmic problem that tests array manipulation
 * and understanding of time/space complexity trade-offs. This implementation
 * uses a brute force approach for educational purposes.
 *
 * Time Complexity: O(n²) where n is the length of the input array
 * Space Complexity: O(1) excluding the output array
 *
 * Note: For production use, consider using a HashMap approach for O(n) time complexity
 */

public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
        int[] result = new int[2];
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if (i == j) continue;

                if(list[i]+list[j] == sum){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}