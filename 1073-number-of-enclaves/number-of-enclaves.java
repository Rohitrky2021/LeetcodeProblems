class Solution {

    // Trick -->Reverse Thinking All 4 Boundries k 1 ko Check dfs Krke Jitne Connected Honge Unko Zero Krdenge
    // those 1's who are left are not connected to any Boundary
   public int numEnclaves(int[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) { // Iterate over all columns as well
            if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
                dfs(grid, i, j);
            }
        }
    }
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) { // Iterate over all columns as well
            if (grid[i][j] == 1) {
                count++;
            }
        }
    }
    return count;
}

    public void dfs(int[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j]==0) {
                return;
            }
    grid[i][j]=0;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);

    }

    static int[][] direc = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
}
