package apple;

import java.util.*;

class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>(m * n);
        
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        
        while (top <= bottom && left <= right) {
            // Traverse right along top row
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;
            
            // Traverse down along right column
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;
            
            // Traverse left along bottom row (if we still have rows)
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }
            
            // Traverse up along left column (if we still have columns)
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }
        
        return result;
    }
    
    // Test method for LeetCode validation
    public static void runTests() {
        SpiralOrder spiralOrder = new SpiralOrder();
        
        // Test Case 1
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> result1 = spiralOrder.spiralOrder(matrix1);
        List<Integer> expected1 = Arrays.asList(1,2,3,6,9,8,7,4,5);
        System.out.println("Test Case 1: " + (result1.equals(expected1) ? "PASS" : "FAIL"));
        
        // Test Case 2
        int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> result2 = spiralOrder.spiralOrder(matrix2);
        List<Integer> expected2 = Arrays.asList(1,2,3,4,8,12,11,10,9,5,6,7);
        System.out.println("Test Case 2: " + (result2.equals(expected2) ? "PASS" : "FAIL"));
        
        // Test Case 3
        int[][] matrix3 = {{1,2,3}};
        List<Integer> result3 = spiralOrder.spiralOrder(matrix3);
        List<Integer> expected3 = Arrays.asList(1,2,3);
        System.out.println("Test Case 3: " + (result3.equals(expected3) ? "PASS" : "FAIL"));
        
        // Test Case 4
        int[][] matrix4 = {{1},{2},{3}};
        List<Integer> result4 = spiralOrder.spiralOrder(matrix4);
        List<Integer> expected4 = Arrays.asList(1,2,3);
        System.out.println("Test Case 4: " + (result4.equals(expected4) ? "PASS" : "FAIL"));
        
        // Test Case 5
        int[][] matrix5 = {{1}};
        List<Integer> result5 = spiralOrder.spiralOrder(matrix5);
        List<Integer> expected5 = Arrays.asList(1);
        System.out.println("Test Case 5: " + (result5.equals(expected5) ? "PASS" : "FAIL"));
    }

    public static void main(String[] args) {
        runTests();
    }
}