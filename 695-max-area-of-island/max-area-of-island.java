class Solution {
    public int maxAreaOfIsland(int[][] grid) {
       int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int count = dfs(i, j, grid);
                    max = Math.max(count, max);
                }
            }
        }
        return max;
    }

    public int dfs(int row, int col, int[][] grid) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1) {
            grid[row][col] = 0;  // Mark as visited
            int count = 1;
            count += dfs(row, col + 1, grid); // right
            count += dfs(row, col - 1, grid); // left
            count += dfs(row + 1, col, grid); // down
            count += dfs(row - 1, col, grid); // up
            return count;
        }
        return 0;
    }
}
