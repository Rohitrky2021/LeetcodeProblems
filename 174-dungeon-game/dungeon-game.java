// class Solution {
//   int inf = Integer.MAX_VALUE;
//   int[][] dp;
//   int rows, cols;

//   public int getMinHealth(int currCell, int nextRow, int nextCol) {
//     if (nextRow >= this.rows || nextCol >= this.cols)
//       return inf;
//     int nextCell = this.dp[nextRow][nextCol];
//     // hero needs at least 1 point to survive
//     return Math.max(1, nextCell - currCell);
//   }

//   public int calculateMinimumHP(int[][] dungeon) {
//     this.rows = dungeon.length;
//     this.cols = dungeon[0].length;
//     this.dp = new int[rows][cols];
//     for (int[] arr : this.dp) {
//       Arrays.fill(arr, this.inf);
//     }
//     int currCell, rightHealth, downHealth, nextHealth, minHealth;
//     for (int row = this.rows - 1; row >= 0; --row) {
//       for (int col = this.cols - 1; col >= 0; --col) {
//         currCell = dungeon[row][col];

//         rightHealth = getMinHealth(currCell, row, col + 1);
//         downHealth = getMinHealth(currCell, row + 1, col);
//         nextHealth = Math.min(rightHealth, downHealth);

//         if (nextHealth != inf) {
//           minHealth = nextHealth;
//         } else {
//           minHealth = currCell >= 0 ? 1 : 1 - currCell;
//         }
//         this.dp[row][col] = minHealth;
//       }
//     }
//     return this.dp[0][0];
//   }
// }
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int[][] memo = new int[rows][cols];

        return calculateMinimumHPRecursive(dungeon, 0, 0, memo);
    }

    private int calculateMinimumHPRecursive(int[][] dungeon, int row, int col, int[][] memo) {
        if (row == dungeon.length - 1 && col == dungeon[0].length - 1) {
            // At the princess cell
            return Math.max(1, 1 - dungeon[row][col]);
        }

        if (row >= dungeon.length || col >= dungeon[0].length) {
            // Out of bounds
            return Integer.MAX_VALUE;
        }

        if (memo[row][col] > 0) {
            // If we have already calculated this cell, return its value
            return memo[row][col];
        }

        // Calculate the minimum health required to reach the princess
        int downHealth = calculateMinimumHPRecursive(dungeon, row + 1, col, memo);
        int rightHealth = calculateMinimumHPRecursive(dungeon, row, col + 1, memo);
        int minHealthOnExit = Math.min(downHealth, rightHealth);

        // Calculate the health needed at this cell
        int cellHealth = dungeon[row][col];
        int minHealth = Math.max(minHealthOnExit - cellHealth, 1);

        // Store the result in the memoization table
        memo[row][col] = minHealth;

        return minHealth;
    }
}



// // // class Solution {

// // //     int[][] dp;

// // //     public int calculateMinimumHP(int[][] grid) {
// // //         int r = grid.length;
// // //         int c = grid[0].length;
// // //         dp = new int[r][c];
// // //         int ans=1;
// // //         if(r==1 && c==1)return ans= (grid[0][0]<=0)? -grid[0][0]+1:ans ;
// // //         dp[r-1][c-1]=1-grid[r-1][c-1];
// // //         return helper(grid, r-1, c-1)+1;
// // //     }
// // //     int helper(int[][] grid, int r, int c) {
// // //         if (r == -1 || c == -1 || dp[r][c]<=0) {
// // //             return Integer.MAX_VALUE; // Return a very large value for out-of-bounds cases
// // //         }

// // //         if (r == 0 && c == 0) {
// // //             return grid[r][c]; // Return the value at the destination
// // //         }

// // //         if (dp[r][c] >0) {
// // //             return dp[r][c]; // If the value is already calculated, return it
// // //         }

// // //         // Calculate the minimum path sum by moving down and right
// // //         int right = helper(grid, r, c - 1);
// // //         int down = helper(grid, r - 1, c);

// // //         // Update the DP table with the minimum path sum at this cell

// // //         return dp[r][c] = Math.min(right, down)-grid[r][c] ;
// // // }
// // // }
// // class Solution {
// //     int[][] dp;

// //     public int calculateMinimumHP(int[][] grid) {
// //         int m = grid.length;
// //         int n = grid[0].length;
// //         dp = new int[m][n];
// //         int ans = 1;
// //         if (m == 1 && n == 1) return ans = (grid[0][0] <= 0) ? -grid[0][0] + 1 : ans;

// //         // Start from the princess room
// //         return Math.max(1, helper(grid, 0, 0) + 1);
// //     }

// //     int helper(int[][] dungeon, int r, int c) {
// //         if (r == dungeon.length || c == dungeon[0].length) {
// //             return Integer.MAX_VALUE; // Return a very large value for out-of-bounds cases
// //         }

// //         if (dp[r][c] > 0) {
// //             return dp[r][c]; // If the value is already calculated, return it
// //         }

// //         // Calculate the minimum initial health required to reach the princess
// //         int right = helper(dungeon, r, c + 1);
// //         int down = helper(dungeon, r + 1, c);

// //         // Calculate the minimum initial health required for the knight
// //         // to survive in this room
// //         int minHealthInThisRoom = Math.min(right, down) - dungeon[r][c];

// //         // Ensure the minimum health required is at least 1
// //         minHealthInThisRoom = Math.max(1, minHealthInThisRoom);

// //         // Update the DP table with the minimum health required in this room
// //         dp[r][c] = minHealthInThisRoom;

// //         return dp[r][c];
// //     }
// // }

// class Solution {
//     int[][] dp;

//     public int calculateMinimumHP(int[][] dungeon) {
//         int m = dungeon.length;
//         int n = dungeon[0].length;
//         dp = new int[m][n];

//         // Start from the princess room
//         return Math.max(1, helper(dungeon, 0, 0) + 1);
//     }

//     int helper(int[][] dungeon, int r, int c) {
//         if (r == dungeon.length || c == dungeon[0].length) {
//             return Integer.MAX_VALUE; // Return a very large value for out-of-bounds cases
//         }

//         if (dp[r][c] > 0) {
//             return dp[r][c]; // If the value is already calculated, return it
//         }

//         // Calculate the minimum initial health required to reach the princess
//         int right = helper(dungeon, r, c + 1);
//         int down = helper(dungeon, r + 1, c);

//         // Calculate the minimum initial health required for the knight
//         // to survive in this room
//         int minHealthInThisRoom = Math.min(right, down) - dungeon[r][c];

//         // Ensure the minimum health required is at least 1
//         minHealthInThisRoom = Math.max(1, minHealthInThisRoom);

//         // Update the DP table with the minimum health required in this room
//         dp[r][c] = minHealthInThisRoom;

//         return dp[r][c];
//     }
// }

// class Solution {
//     int[][] dp;

//     public int calculateMinimumHP(int[][] dungeon) {
//         int m = dungeon.length;
//         int n = dungeon[0].length;
//         dp = new int[m][n];

//         // Start from the princess room
//         return Math.max(1, helper(dungeon, 0, 0));
//     }

//     int helper(int[][] dungeon, int r, int c) {
//         if (r == dungeon.length || c == dungeon[0].length) {
//             return Integer.MAX_VALUE; // Return a very large value for out-of-bounds cases
//         }

//         if (dp[r][c] > 0) {
//             return dp[r][c]; // If the value is already calculated, return it
//         }

//         // Calculate the minimum initial health required to reach the princess
//         int right = helper(dungeon, r, c + 1);
//         int down = helper(dungeon, r + 1, c);

//         // Calculate the minimum initial health required for the knight
//         // to survive in this room
//         int minHealthInThisRoom = Math.min(right, down) - dungeon[r][c];

//         // Update the DP table with the minimum health required in this room
//         dp[r][c] = Math.max(1, minHealthInThisRoom);

//         return dp[r][c];
//     }
// }

