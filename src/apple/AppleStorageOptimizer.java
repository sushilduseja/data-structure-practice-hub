package apple;

import java.util.*;

class AppleStorageOptimizer {
    public int minimumBoxes(int[] apple, int[] capacity) {
        // Input validation (though constraints guarantee valid input)
        if (apple == null || capacity == null || apple.length == 0 || capacity.length == 0) {
            return 0;
        }
        
        // Step 1: Calculate total apples to redistribute
        int totalApples = 0;
        for (int apples : apple) {
            totalApples += apples;
        }
        
        // Step 2: Sort boxes by capacity in descending order (largest first)
        // Create copy to preserve original array
        Integer[] sortedCapacity = new Integer[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            sortedCapacity[i] = capacity[i];
        }
        Arrays.sort(sortedCapacity, Collections.reverseOrder());
        
        // Step 3: Greedy selection - use largest boxes until all apples are accommodated
        int boxesUsed = 0;
        int currentCapacity = 0;
        
        for (int boxCapacity : sortedCapacity) {
            currentCapacity += boxCapacity;
            boxesUsed++;
            
            // Check if we've accommodated all apples
            if (currentCapacity >= totalApples) {
                break;
            }
        }
        
        return boxesUsed;
    }
    
    // Alternative implementation with in-place sorting for space optimization
    public int minimumBoxesOptimized(int[] apple, int[] capacity) {
        // Calculate total apples
        int totalApples = Arrays.stream(apple).sum();
        
        // Sort capacity in descending order (modifies original array)
        Arrays.sort(capacity);
        
        // Greedy selection from largest to smallest
        int boxesUsed = 0;
        int currentCapacity = 0;
        
        for (int i = capacity.length - 1; i >= 0; i--) {
            currentCapacity += capacity[i];
            boxesUsed++;
            
            if (currentCapacity >= totalApples) {
                break;
            }
        }
        
        return boxesUsed;
    }
    
    // Test method for LeetCode validation
    static public void runTests() {
        AppleStorageOptimizer appleStorageOptimizer = new AppleStorageOptimizer();
        
        // Test Case 1
        int[] apple1 = {1,3,2};
        int[] capacity1 = {4,3,1,5,2};
        int result1 = appleStorageOptimizer.minimumBoxesOptimized(apple1, capacity1);
        System.out.println("Test Case 1: " + (result1 == 2 ? "PASS" : "FAIL") + 
                          " (Expected: 2, Got: " + result1 + ")");
        
        // Test Case 2
        int[] apple2 = {5,5,5};
        int[] capacity2 = {2,4,2,7};
        int result2 = appleStorageOptimizer.minimumBoxesOptimized(apple2, capacity2);
        System.out.println("Test Case 2: " + (result2 == 4 ? "PASS" : "FAIL") + 
                          " (Expected: 4, Got: " + result2 + ")");
        
        // Test Case 3
        int[] apple3 = {1};
        int[] capacity3 = {1};
        int result3 = appleStorageOptimizer.minimumBoxesOptimized(apple3, capacity3);
        System.out.println("Test Case 3: " + (result3 == 1 ? "PASS" : "FAIL") + 
                          " (Expected: 1, Got: " + result3 + ")");
        
        // Test Case 4
        int[] apple4 = {10};
        int[] capacity4 = {20,15,5,3};
        int result4 = appleStorageOptimizer.minimumBoxesOptimized(apple4, capacity4);
        System.out.println("Test Case 4: " + (result4 == 1 ? "PASS" : "FAIL") + 
                          " (Expected: 1, Got: " + result4 + ")");
        
        // Test Case 5
        int[] apple5 = {1,1,1,1,1};
        int[] capacity5 = {1,1,1,1,1};
        int result5 = appleStorageOptimizer.minimumBoxesOptimized(apple5, capacity5);
        System.out.println("Test Case 5: " + (result5 == 5 ? "PASS" : "FAIL") + 
                          " (Expected: 5, Got: " + result5 + ")");
        
        // Test Case 6
        int[] apple6 = {2,4,6};
        int[] capacity6 = {10,5,1,3};
        int result6 = appleStorageOptimizer.minimumBoxesOptimized(apple6, capacity6);
        System.out.println("Test Case 6: " + (result6 == 2 ? "PASS" : "FAIL") + 
                          " (Expected: 2, Got: " + result6 + ")");
    }

    public static void main(String[] args) {
        runTests();
    }
}