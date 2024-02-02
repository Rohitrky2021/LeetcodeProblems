class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        
        // If grid size is 1x1, return the maximum of 0 and the value of the single cell
        if (n == 1) 
            return Math.max(0, grid[0][0]);
        
        // Initialize memoization array
        int[][][] dp = new int[50][50][50]; // Maximum size, can be adjusted based on constraints
        
        // Perform DFS traversal
        dfs(grid, 0, 0, 0, dp, n); 
        
        // Return the maximum cherries collected
        return Math.max(0, dp[0][0][0]); 
    }

    // DFS traversal function
    int dfs(int[][] arr, int r1, int c1, int c2, int[][][] dp, int n) {
        int r2 = r1 + c1 - c2; // Calculate the row for the second robot
        
        // Check if any of the indices are out of bounds or if any of the cells are blocked
        if (r1 >= n || r2 >= n || c1 >= n || c2 >= n || arr[r1][c1] == -1 || arr[r2][c2] == -1) 
            return Integer.MIN_VALUE; // Return MIN_VALUE for unreachable states
        
        // Return memoized value if available
        if (dp[r1][c1][c2] != 0) 
            return dp[r1][c1][c2];
        
        // Base case: reached the bottom-right cell
        if (r1 == n - 1 && c1 == n - 1) 
            return arr[n - 1][n - 1];
        
        // Initialize the cherries collected at the current cell
        int ans = arr[r1][c1];
        
        // Add cherries from the second robot if it's not on the same cell
        if (c1 != c2) 
            ans += arr[r2][c2];
        
        // Recursive calls for all possible moves
        int dd = dfs(arr, r1 + 1, c1, c2, dp, n);
        int rd = dfs(arr, r1, c1 + 1, c2, dp, n);
        int dr = dfs(arr, r1 + 1, c1, c2 + 1, dp, n);
        int rr = dfs(arr, r1, c1 + 1, c2 + 1, dp, n);
        
        // Memoize the maximum cherries and return
        return dp[r1][c1][c2] = Math.max(dd, Math.max(rd, Math.max(dr, rr))) + ans;
    }
}
