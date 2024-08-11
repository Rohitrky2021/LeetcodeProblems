class Solution {
    public int minDays(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Check initial number of islands
        if (numofisland(grid) > 1 || numofisland(grid) ==0 ) return 0;

        // Try removing each land cell and check the number of islands
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (numofisland(grid) > 1 || numofisland(grid) ==0 ) {
                        return 1;
                    }
                    grid[i][j] = 1; // Revert change if it didn't split the islands
                }
            }
        }

        return 2; // If no single cell removal can split the island into more than one part
    }

    public int numofisland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] vis = new boolean[rows][cols];
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    dfs(grid, vis, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, boolean[][] vis, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == 0 || vis[i][j]) {
            return;
        }

        vis[i][j] = true;

        dfs(grid, vis, i + 1, j);
        dfs(grid, vis, i - 1, j);
        dfs(grid, vis, i, j + 1);
        dfs(grid, vis, i, j - 1);
    }
}
