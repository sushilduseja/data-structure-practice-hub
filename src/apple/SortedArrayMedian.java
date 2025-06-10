package apple;

class SortedArrayMedian {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array for optimization
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int totalLen = m + n;
        int leftHalfSize = (totalLen + 1) / 2;
        
        int left = 0, right = m;
        
        while (left <= right) {
            int i = (left + right) / 2;  // partition point for nums1
            int j = leftHalfSize - i;    // partition point for nums2
            
            // Get boundary values (handle edge cases with MIN/MAX_VALUE)
            int leftMax1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int rightMin1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            
            int leftMax2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int rightMin2 = (j == n) ? Integer.MAX_VALUE : nums2[j];
            
            // Check if we found the correct partition
            if (leftMax1 <= rightMin2 && leftMax2 <= rightMin1) {
                // Perfect partition found
                if (totalLen % 2 == 1) {
                    // Odd total length - median is max of left side
                    return Math.max(leftMax1, leftMax2);
                } else {
                    // Even total length - median is average of middle two elements
                    return (Math.max(leftMax1, leftMax2) + Math.min(rightMin1, rightMin2)) / 2.0;
                }
            } else if (leftMax1 > rightMin2) {
                // Too many elements from nums1, reduce i
                right = i - 1;
            } else {
                // Too few elements from nums1, increase i
                left = i + 1;
            }
        }
        
        // Should never reach here with valid input
        throw new IllegalArgumentException("Input arrays are not sorted");
    }
    
    // Test method for LeetCode validation
    public static void runTests() {
        SortedArrayMedian sortedArrayMedian = new SortedArrayMedian();
        
        // Test Case 1
        int[] nums1_1 = {1, 3};
        int[] nums2_1 = {2};
        double result1 = sortedArrayMedian.findMedianSortedArrays(nums1_1, nums2_1);
        System.out.println("Test Case 1: " + (Math.abs(result1 - 2.0) < 1e-9 ? "PASS" : "FAIL"));
        
        // Test Case 2
        int[] nums1_2 = {1, 2};
        int[] nums2_2 = {3, 4};
        double result2 = sortedArrayMedian.findMedianSortedArrays(nums1_2, nums2_2);
        System.out.println("Test Case 2: " + (Math.abs(result2 - 2.5) < 1e-9 ? "PASS" : "FAIL"));
        
        // Test Case 3
        int[] nums1_3 = {};
        int[] nums2_3 = {1};
        double result3 = sortedArrayMedian.findMedianSortedArrays(nums1_3, nums2_3);
        System.out.println("Test Case 3: " + (Math.abs(result3 - 1.0) < 1e-9 ? "PASS" : "FAIL"));
        
        // Test Case 4
        int[] nums1_4 = {1, 2, 3, 4, 5};
        int[] nums2_4 = {6, 7, 8, 9, 10};
        double result4 = sortedArrayMedian.findMedianSortedArrays(nums1_4, nums2_4);
        System.out.println("Test Case 4: " + (Math.abs(result4 - 5.5) < 1e-9 ? "PASS" : "FAIL"));
        
        // Test Case 5
        int[] nums1_5 = {1, 3, 5};
        int[] nums2_5 = {2, 4, 6, 7, 8};
        double result5 = sortedArrayMedian.findMedianSortedArrays(nums1_5, nums2_5);
        System.out.println("Test Case 5: " + (Math.abs(result5 - 4.5) < 1e-9 ? "PASS" : "FAIL"));
    }

    public static void main(String[] args) {
        runTests();
    }
}