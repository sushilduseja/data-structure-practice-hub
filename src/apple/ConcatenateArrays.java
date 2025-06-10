package apple;

class ConcatenateArrays {
    public int[] getConcatenation(int[] nums) {
        // Input validation (though constraints guarantee valid input)
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] ans = new int[2 * n];

        // Approach 1: Direct two-phase copy (most readable)
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];           // First copy
            ans[i + n] = nums[i];       // Second copy
        }

        return ans;
    }
    
    // Alternative implementation using modulo approach
    public int[] getConcatenationModulo(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        
        // Single loop with modulo arithmetic  
        for (int i = 0; i < 2 * n; i++) {
            ans[i] = nums[i % n];
        }
        
        return ans;
    }
    
    // Alternative implementation using System.arraycopy for performance
    public int[] getConcatenationSystemCopy(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        
        // Use System.arraycopy for optimal performance
        System.arraycopy(nums, 0, ans, 0, n);     // Copy first half
        System.arraycopy(nums, 0, ans, n, n);     // Copy second half
        
        return ans;
    }
    
    // One-liner approach using Arrays utility (less efficient but concise)
    public int[] getConcatenationOneLiner(int[] nums) {
        int[] ans = new int[nums.length * 2];
        System.arraycopy(nums, 0, ans, 0, nums.length);
        System.arraycopy(nums, 0, ans, nums.length, nums.length);
        return ans;
    }
    
    // Test method for LeetCode validation
    public static void runTests() {
        ConcatenateArrays concatenateArrays = new ConcatenateArrays();
        
        // Test Case 1
        int[] nums1 = {1,2,1};
        int[] result1 = concatenateArrays.getConcatenation(nums1);
        int[] expected1 = {1,2,1,1,2,1};
        boolean pass1 = java.util.Arrays.equals(result1, expected1);
        System.out.println("Test Case 1: " + (pass1 ? "PASS" : "FAIL") + 
                          " (Expected: " + java.util.Arrays.toString(expected1) + 
                          ", Got: " + java.util.Arrays.toString(result1) + ")");
        
        // Test Case 2
        int[] nums2 = {1,3,2,1};
        int[] result2 = concatenateArrays.getConcatenation(nums2);
        int[] expected2 = {1,3,2,1,1,3,2,1};
        boolean pass2 = java.util.Arrays.equals(result2, expected2);
        System.out.println("Test Case 2: " + (pass2 ? "PASS" : "FAIL") + 
                          " (Expected: " + java.util.Arrays.toString(expected2) + 
                          ", Got: " + java.util.Arrays.toString(result2) + ")");
        
        // Test Case 3
        int[] nums3 = {1};
        int[] result3 = concatenateArrays.getConcatenation(nums3);
        int[] expected3 = {1,1};
        boolean pass3 = java.util.Arrays.equals(result3, expected3);
        System.out.println("Test Case 3: " + (pass3 ? "PASS" : "FAIL") + 
                          " (Expected: " + java.util.Arrays.toString(expected3) + 
                          ", Got: " + java.util.Arrays.toString(result3) + ")");
        
        // Test Case 4
        int[] nums4 = {5,4,3,2,1};
        int[] result4 = concatenateArrays.getConcatenation(nums4);
        int[] expected4 = {5,4,3,2,1,5,4,3,2,1};
        boolean pass4 = java.util.Arrays.equals(result4, expected4);
        System.out.println("Test Case 4: " + (pass4 ? "PASS" : "FAIL") + 
                          " (Expected: " + java.util.Arrays.toString(expected4) + 
                          ", Got: " + java.util.Arrays.toString(result4) + ")");
        
        // Test Case 5
        int[] nums5 = {1,1,1};
        int[] result5 = concatenateArrays.getConcatenation(nums5);
        int[] expected5 = {1,1,1,1,1,1};
        boolean pass5 = java.util.Arrays.equals(result5, expected5);
        System.out.println("Test Case 5: " + (pass5 ? "PASS" : "FAIL") + 
                          " (Expected: " + java.util.Arrays.toString(expected5) + 
                          ", Got: " + java.util.Arrays.toString(result5) + ")");
        
        // Test Case 6
        int[] nums6 = {1,2,3,4,5,6};
        int[] result6 = concatenateArrays.getConcatenation(nums6);
        int[] expected6 = {1,2,3,4,5,6,1,2,3,4,5,6};
        boolean pass6 = java.util.Arrays.equals(result6, expected6);
        System.out.println("Test Case 6: " + (pass6 ? "PASS" : "FAIL") + 
                          " (Expected: " + java.util.Arrays.toString(expected6) + 
                          ", Got: " + java.util.Arrays.toString(result6) + ")");
    }

    public static void main(String[] args) {
        runTests();
    }
}