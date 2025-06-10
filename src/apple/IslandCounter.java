package apple;

class IslandCounter {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int islandCount = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    dfs(grid, i, j);
                }
            }
        }
        
        return islandCount;
    }
    
    private void dfs(char[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Base case: out of bounds or water/visited cell
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == '0') {
            return;
        }
        
        // Mark current cell as visited by sinking it
        grid[row][col] = '0';
        
        // Explore all 4 directions
        dfs(grid, row - 1, col); // up
        dfs(grid, row + 1, col); // down
        dfs(grid, row, col - 1); // left
        dfs(grid, row, col + 1); // right
    }
    
    // Test method for LeetCode validation
    static public void runTests() {
        IslandCounter islandCounter = new IslandCounter();
        
        // Test Case 1
        char[][] grid1 = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        int result1 = islandCounter.numIslands(grid1);
        System.out.println("Test Case 1: " + (result1 == 1 ? "PASS" : "FAIL") + 
                          " (Expected: 1, Got: " + result1 + ")");
        
        // Test Case 2  
        char[][] grid2 = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        int result2 = islandCounter.numIslands(grid2);
        System.out.println("Test Case 2: " + (result2 == 3 ? "PASS" : "FAIL") + 
                          " (Expected: 3, Got: " + result2 + ")");
        
        // Test Case 3
        char[][] grid3 = {{'1'}};
        int result3 = islandCounter.numIslands(grid3);
        System.out.println("Test Case 3: " + (result3 == 1 ? "PASS" : "FAIL") + 
                          " (Expected: 1, Got: " + result3 + ")");
        
        // Test Case 4
        char[][] grid4 = {{'0'}};
        int result4 = islandCounter.numIslands(grid4);
        System.out.println("Test Case 4: " + (result4 == 0 ? "PASS" : "FAIL") + 
                          " (Expected: 0, Got: " + result4 + ")");
        
        // Test Case 5
        char[][] grid5 = {
            {'1','1','1'},
            {'1','1','1'},
            {'1','1','1'}
        };
        int result5 = islandCounter.numIslands(grid5);
        System.out.println("Test Case 5: " + (result5 == 1 ? "PASS" : "FAIL") + 
                          " (Expected: 1, Got: " + result5 + ")");
    }

    public static void main(String[] args) {
        runTests();
    }
}