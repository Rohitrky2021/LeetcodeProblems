class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        
        // Traverse through the grid2 to mark non-sub islands.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1 && grid1[i][j] != 1) {
                    // Mark the entire island as non-sub island.
                    dfs(grid2, i, j);
                }
            }
        }
        
        int count = 0;
        
        // Count sub-islands in grid2 that are also islands in grid1.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1) {
                    count++;
                    dfs(grid2, i, j);
                }
            }
        }
        
        return count;
    }
    
    private void dfs(int[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != 1) {
            return;
        }
        
        grid[i][j] = -1; // Mark the cell as visited.
        
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
