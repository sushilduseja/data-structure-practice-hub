package apple;

import java.util.*;

class FrogJump {
    public boolean canCross(int[] stones) {
        if (stones.length < 2) return true;
        if (stones[1] != 1) return false; // First jump must be 1 unit
        
        // Map stone positions to their indices for O(1) lookup
        Map<Integer, Set<Integer>> stoneToJumps = new HashMap<>();
        for (int stone : stones) {
            stoneToJumps.put(stone, new HashSet<>());
        }
        
        // Base case: frog starts at position 0 with jump distance 0
        stoneToJumps.get(0).add(0);
        
        // Process each stone in order
        for (int stone : stones) {
            Set<Integer> jumps = stoneToJumps.get(stone);
            
            for (int jump : jumps) {
                // Try all three possible next jumps: jump-1, jump, jump+1
                for (int nextJump = jump - 1; nextJump <= jump + 1; nextJump++) {
                    if (nextJump > 0) { // Can't have zero or negative jump
                        int nextStone = stone + nextJump;
                        if (stoneToJumps.containsKey(nextStone)) {
                            stoneToJumps.get(nextStone).add(nextJump);
                        }
                    }
                }
            }
        }
        
        // Check if the last stone is reachable (has any possible jumps)
        return !stoneToJumps.get(stones[stones.length - 1]).isEmpty();
    }
    
    // Test method for LeetCode validation
    public static void runTests() {
        FrogJump frogJump = new FrogJump();
        
        // Test Case 1
        int[] stones1 = {0, 1, 3, 5, 6, 8, 12, 17};
        boolean result1 = frogJump.canCross(stones1);
        System.out.println("Test Case 1: " + (result1 == true ? "PASS" : "FAIL"));
        
        // Test Case 2
        int[] stones2 = {0, 1, 2, 3, 4, 8, 9, 11};
        boolean result2 = frogJump.canCross(stones2);
        System.out.println("Test Case 2: " + (result2 == false ? "PASS" : "FAIL"));
        
        // Test Case 3
        int[] stones3 = {0, 1};
        boolean result3 = frogJump.canCross(stones3);
        System.out.println("Test Case 3: " + (result3 == true ? "PASS" : "FAIL"));
        
        // Test Case 4
        int[] stones4 = {0, 2};
        boolean result4 = frogJump.canCross(stones4);
        System.out.println("Test Case 4: " + (result4 == false ? "PASS" : "FAIL"));
        
        // Test Case 5
        int[] stones5 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        boolean result5 = frogJump.canCross(stones5);
        System.out.println("Test Case 5: " + (result5 == true ? "PASS" : "FAIL"));
    }

    public static void main(String[] args) {
        runTests();
    }
}