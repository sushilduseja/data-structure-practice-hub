package apple;

class MaxSubarrayCalculator {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        
        int maxSum = nums[0];        // Maximum sum found so far
        int currentSum = nums[0];    // Sum of current subarray
        
        for (int i = 1; i < nums.length; i++) {
            // Decision: extend current subarray or start new one
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            
            // Update global maximum if current is better
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
    
    // Alternative implementation showing the logic more explicitly
    public int maxSubArrayVerbose(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        
        for (int num : nums) {
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
            
            // If current sum becomes negative, reset to 0
            // (equivalent to starting fresh from next element)
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        
        return maxSum;
    }
    
    // Test method for LeetCode validation
    static public void runTests() {
        MaxSubarrayCalculator maxSubarrayCalculator = new MaxSubarrayCalculator();
        
        // Test Case 1
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        int result1 = maxSubarrayCalculator.maxSubArray(nums1);
        System.out.println("Test Case 1: " + (result1 == 6 ? "PASS" : "FAIL") + 
                          " (Expected: 6, Got: " + result1 + ")");
        
        // Test Case 2
        int[] nums2 = {1};
        int result2 = maxSubarrayCalculator.maxSubArray(nums2);
        System.out.println("Test Case 2: " + (result2 == 1 ? "PASS" : "FAIL") + 
                          " (Expected: 1, Got: " + result2 + ")");
        
        // Test Case 3
        int[] nums3 = {5,4,-1,7,8};
        int result3 = maxSubarrayCalculator.maxSubArray(nums3);
        System.out.println("Test Case 3: " + (result3 == 23 ? "PASS" : "FAIL") + 
                          " (Expected: 23, Got: " + result3 + ")");
        
        // Test Case 4
        int[] nums4 = {-2,-1,-3,-4,-1,-2,-1,-5,-4};
        int result4 = maxSubarrayCalculator.maxSubArray(nums4);
        System.out.println("Test Case 4: " + (result4 == -1 ? "PASS" : "FAIL") + 
                          " (Expected: -1, Got: " + result4 + ")");
        
        // Test Case 5
        int[] nums5 = {-2,1,-3,4,-1,2,1,-5,4,10,-1,2};
        int result5 = maxSubarrayCalculator.maxSubArray(nums5);
        System.out.println("Test Case 5: " + (result5 == 16 ? "PASS" : "FAIL") +
                          " (Expected: 16, Got: " + result5 + ")");
        
        // Test Case 6
        int[] nums6 = {1,2,3,4,5};
        int result6 = maxSubarrayCalculator.maxSubArray(nums6);
        System.out.println("Test Case 6: " + (result6 == 15 ? "PASS" : "FAIL") +
                          " (Expected: 15, Got: " + result6 + ")");
    }

    public static void main(String[] args) {
        runTests();
    }
}