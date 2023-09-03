// class Solution {
//     int[][] dp;
//     int mod = 1_000_000_007;

//     public int minPathSum(int[][] grid) {
//         int rows = grid.length;
//         int cols = grid[0].length;
//         dp = new int[rows][cols];

//         return helper(grid, 0, 0, 0, Integer.MAX_VALUE);
//     }

//     int helper(int[][] grid, int r, int c, int sum, int k) {
//         if (r == grid.length || c == grid[0].length) {
//             return Integer.MAX_VALUE;
//         }

//         sum += grid[r][c];
//         if (r == grid.length - 1 && c == grid[0].length - 1) { // r==m-1 && c==n-1
//         System.out.println(sum+" "+grid[r][c]);
//             return grid[r][c];    
//         }

//         // For this Think iun 3D i.e -> for every r,c their will be List of sum%k values
//         if (dp[r][c] > 0) {
//             return dp[r][c]; // i.r eske pehle ka Remainder i have handleded end result same hoga as Sum of + This Remainder
//         }

//         return dp[r][c] =  grid[r][c] +Math.min(helper(grid, r + 1, c, sum, k) , helper(grid, r, c + 1, sum, k) ); 
//     }
// }

class Solution {
    int[][] dp;

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        dp = new int[rows][cols];

        // Initialize the DP table with maximum values
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(grid, 0, 0);
    }

    int helper(int[][] grid, int r, int c) {
        if (r == grid.length || c == grid[0].length) {
            return Integer.MAX_VALUE; // Return a very large value for out-of-bounds cases
        }

        if (r == grid.length - 1 && c == grid[0].length - 1) {
            return grid[r][c]; // Return the value at the destination
        }

        if (dp[r][c] != -1) {
            return dp[r][c]; // If the value is already calculated, return it
        }

        // Calculate the minimum path sum by moving down and right
        int right = helper(grid, r, c + 1);
        int down = helper(grid, r + 1, c);

        // Update the DP table with the minimum path sum at this cell
        dp[r][c] = grid[r][c] + Math.min(right, down);

        return dp[r][c];
    }
}

