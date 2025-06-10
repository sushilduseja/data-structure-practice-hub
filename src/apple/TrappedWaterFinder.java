package apple;

class TrappedWaterFinder {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) return 0;

        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        // Fill maxLeft array
        maxLeft[0] = height[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }

        // Fill maxRight array
        maxRight[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }

        // Compute trapped water
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }

        return water;
    }
    
    // Test method for LeetCode validation
    public static void runTests() {
        TrappedWaterFinder trappedWaterFinder = new TrappedWaterFinder();
        
        // Test Case 1
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result1 = trappedWaterFinder.trap(height1);
        System.out.println("Test Case 1: " + (result1 == 6 ? "PASS" : "FAIL"));
        
        // Test Case 2
        int[] height2 = {4, 2, 0, 3, 2, 5};
        int result2 = trappedWaterFinder.trap(height2);
        System.out.println("Test Case 2: " + (result2 == 9 ? "PASS" : "FAIL"));
        
        // Test Case 3
        int[] height3 = {1};
        int result3 = trappedWaterFinder.trap(height3);
        System.out.println("Test Case 3: " + (result3 == 0 ? "PASS" : "FAIL"));
        
        // Test Case 4
        int[] height4 = {1, 2, 3, 4, 5};
        int result4 = trappedWaterFinder.trap(height4);
        System.out.println("Test Case 4: " + (result4 == 0 ? "PASS" : "FAIL"));
        
        // Test Case 5
        int[] height5 = {5, 4, 3, 2, 1};
        int result5 = trappedWaterFinder.trap(height5);
        System.out.println("Test Case 5: " + (result5 == 0 ? "PASS" : "FAIL"));
        
        // Test Case 6
        int[] height6 = {3, 0, 2, 0, 4};
        int result6 = trappedWaterFinder.trap(height6);
        System.out.println("Test Case 6: " + (result6 == 7 ? "PASS" : "FAIL"));
    }

    public static void main(String[] args) {
        runTests();
    }
}