class Solution {

   

    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0) { // Start DFS from cells with nonzero score
                    maxGold = Math.max(maxGold, dfs(grid, i, j));
                }
            }
        }

        return maxGold;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0; // Base case: out of bounds or cell has 0 score
        }

        int score = grid[row][col];
        grid[row][col] = 0; // Mark current cell as visited

        // Explore all possible directions: left, right, up, down
        int maxGold = score + Math.max(
                Math.max(dfs(grid, row, col - 1), dfs(grid, row, col + 1)),
                Math.max(dfs(grid, row - 1, col), dfs(grid, row + 1, col))
        );

        grid[row][col] = score; // Restore the grid

        return maxGold;
    }
}
