class Solution1 {
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
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int count = 0;

        // Iterate over every cell in grid2
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Start DFS if we find an island in grid2
                if (grid2[i][j] == 1) {
                    // If the DFS confirms it's a sub-island, increment the count
                    if (dfs(grid1, grid2, i, j)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        int m = grid1.length;
        int n = grid1[0].length;

        // Boundary conditions
        if (i < 0 || j < 0 || i >= m || j >= n || grid2[i][j] == 0) {
            return true;
        }

        // If grid2 has land but grid1 doesn't, it's not a sub-island
        if (grid1[i][j] == 0) {
            return false;
        }

        // Mark this cell as visited in grid2
        grid2[i][j] = 0;

        // Perform DFS in all four directions
        boolean isSubIsland = true;
        isSubIsland &= dfs(grid1, grid2, i + 1, j);
        isSubIsland &= dfs(grid1, grid2, i - 1, j);
        isSubIsland &= dfs(grid1, grid2, i, j + 1);
        isSubIsland &= dfs(grid1, grid2, i, j - 1);

        return isSubIsland;
    }
}
