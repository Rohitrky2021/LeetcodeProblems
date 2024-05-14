class Solution1 {

//    : O(m⋅n⋅4^g)  {g==gold cell!=0}
 

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

class Solution2 {
    int max = 0;
    public int getMaximumGold(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                 if(grid[i][j] != 0) {
                    trackPath(i,j, grid, 0);
                 }
            }
        }
       return max;
    }

    private void trackPath(int i, int j, int[][] grid, int sum) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            max = Math.max(max, sum);
            return;
        }
        int val = grid[i][j];
        sum += val; 
        grid[i][j] = 0;
        trackPath(i + 1, j, grid, sum);
        trackPath(i - 1, j, grid, sum);
        trackPath(i, j + 1, grid, sum);
        trackPath(i, j - 1, grid, sum);
        grid[i][j] = val;

    }
}

class Solution {
    public int dfs(int[][] grid, int row, int col){
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] <= 0) {
            return 0;
        }

        grid[row][col] = -grid[row][col];

        int down = dfs(grid, row+1, col);
        int right = dfs(grid, row, col+1);
        int up = dfs(grid, row-1, col);
        int left = dfs(grid, row, col-1);

        grid[row][col] = -grid[row][col];

        return grid[row][col] + Math.max(Math.max(left, right), Math.max(up, down));
    }

    public int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }
}