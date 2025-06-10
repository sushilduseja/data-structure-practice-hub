package apple;

import java.util.*;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must contain at least 2 elements");
        }

        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement), i};
            }

            numToIndex.put(nums[i], i);
        }

        // This should never happen given the problem constraints
        //throw new IllegalArgumentException("No two sum solution exists");
        return null;
    }

    // Test method for LeetCode format
    public static List<Object> executeOperations(String[] operations, Object[][] values) {
        List<Object> result = new ArrayList<>();
        TwoSum solution = new TwoSum();

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "twoSum":
                    int[] nums = (int[]) values[i][0];
                    int target = (Integer) values[i][1];
                    result.add(Arrays.toString(solution.twoSum(nums, target)));
                    break;
            }
        }

        return result;
    }

    // Helper method to compare arrays in results
    public static boolean arraysEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    // Test runner method
    public static void runTests() {
        TwoSum solution = new TwoSum();

        // Test Case 1: Basic example
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] expected1 = {0, 1};
        int[] actual1 = solution.twoSum(nums1, target1);
        System.out.println("Test Case 1: " + (arraysEqual(expected1.clone(), actual1.clone()) ? "PASS" : "FAIL"));
        System.out.println("Input");
        System.out.println("nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output");
        System.out.println(Arrays.toString(actual1));
        System.out.println();

        // Test Case 2: Different order
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] expected2 = {1, 2};
        int[] actual2 = solution.twoSum(nums2, target2);
        System.out.println("Test Case 2: " + (arraysEqual(expected2.clone(), actual2.clone()) ? "PASS" : "FAIL"));
        System.out.println("Input");
        System.out.println("nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output");
        System.out.println(Arrays.toString(actual2));
        System.out.println();

        // Test Case 3: Duplicate numbers
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] expected3 = {0, 1};
        int[] actual3 = solution.twoSum(nums3, target3);
        System.out.println("Test Case 3: " + (arraysEqual(expected3.clone(), actual3.clone()) ? "PASS" : "FAIL"));
        System.out.println("Input");
        System.out.println("nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Output");
        System.out.println(Arrays.toString(actual3));
        System.out.println();

        // Test Case 4: Negative numbers
        int[] nums4 = {-1, -2, -3, -4, -5};
        int target4 = -8;
        int[] expected4 = {2, 4};
        int[] actual4 = solution.twoSum(nums4, target4);
        System.out.println("Test Case 4: " + (arraysEqual(expected4.clone(), actual4.clone()) ? "PASS" : "FAIL"));
        System.out.println("Input");
        System.out.println("nums = " + Arrays.toString(nums4) + ", target = " + target4);
        System.out.println("Output");
        System.out.println(Arrays.toString(actual4));
        System.out.println();

        // Test Case 5: Large numbers
        int[] nums5 = {1000000000, 999999999, 1};
        int target5 = 1999999999;
        int[] expected5 = {0, 1};
        int[] actual5 = solution.twoSum(nums5, target5);
        System.out.println("Test Case 5: " + (arraysEqual(expected5.clone(), actual5.clone()) ? "PASS" : "FAIL"));
        System.out.println("Input");
        System.out.println("nums = " + Arrays.toString(nums5) + ", target = " + target5);
        System.out.println("Output");
        System.out.println(Arrays.toString(actual5));
        System.out.println();

        // Test Case 6: Zero sum
        int[] nums6 = {-3, 4, 3, 90};
        int target6 = 0;
        int[] expected6 = {0, 2};
        int[] actual6 = solution.twoSum(nums6, target6);
        System.out.println("Test Case 6: " + (arraysEqual(expected6.clone(), actual6.clone()) ? "PASS" : "FAIL"));
        System.out.println("Input");
        System.out.println("nums = " + Arrays.toString(nums6) + ", target = " + target6);
        System.out.println("Output");
        System.out.println(Arrays.toString(actual6));
        System.out.println();
    }

    public static void main(String[] args) {
        runTests();
    }
}