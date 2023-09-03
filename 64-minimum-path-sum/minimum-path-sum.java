class Solution {
    int[][] dp;
    int mod = 1_000_000_007;

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        dp = new int[rows][cols];

        return helper(grid, 0, 0, 0, Integer.MAX_VALUE);
    }

    int helper(int[][] grid, int r, int c, int sum, int k) {
        if (r == grid.length || c == grid[0].length) {
            return Integer.MAX_VALUE;
        }

        sum += grid[r][c];
        if (r == grid.length - 1 && c == grid[0].length - 1) { // r==m-1 && c==n-1
        System.out.println(sum+" "+grid[r][c]);
            return grid[r][c];    
        }

        // For this Think iun 3D i.e -> for every r,c their will be List of sum%k values
        if (dp[r][c] > 0) {
            return dp[r][c]; // i.r eske pehle ka Remainder i have handleded end result same hoga as Sum of + This Remainder
        }

        return dp[r][c] =  grid[r][c] +Math.min(helper(grid, r + 1, c, sum, k) , helper(grid, r, c + 1, sum, k) ); 
    }
}
