//    public int cherryPickup(int[][] grid) {
//         int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        
//         return solve(grid, dp, 0, 0, grid[0].length-1);
//     }
    
//     int[][] dir = new int[][]{{1,0}, {1,-1}, {1,1}}; // a matrix to store the directions that i can move to
//     public int solve(int[][] grid, int[][][] dp, int row, int r1, int r2) {
//         if (!check(row, r1, grid.length, grid[0].length) || !check(row, r2, grid.length, grid[0].length)) // check if one robot go out of the matrix border we will cancel this state bt return Integer.MIN_VALUE
//             return Integer.MIN_VALUE;
//         if (dp[row][r1][r2] != 0) // if this state already visited, we don't need to continue, we will return the stored score for this state
//             return dp[row][r1][r2];
        
//         int max = 0; // this will store the maximum score from the next row
//         int sum = 0; // this will store the score that i can get for this row
//         if (r1 == r2) { // if both robots on the same cell, only one of them will take the points in that cell
//             sum = grid[row][r1];
//         } else { // otherwise, each one of them will take the points on its cell
//             sum = grid[row][r1] + grid[row][r2];
//         }
        
//         if (row == grid.length-1) // if we reach the last row we will return the score of that row
//             return sum;
        
// 		// these nested loops will go through the 9 directions we talked about above.
//         for (int i = 0 ; i < 3; i++) {
//             for (int j = 0 ; j < 3; j++) {
//                 int nextRow = row + dir[i][0];
//                 int nextR1 = r1 + dir[i][1];
//                 int nextR2 = r2 + dir[j][1];
//                 max = Math.max(max, solve(grid, dp, nextRow, nextR1, nextR2)); // find the maximum score we can get from this state
//             }
//         }
        
//         if (max > 0) {
//             dp[row][r1][r2] = sum + max;
//             return sum + max;
//         } 
//         return Integer.MIN_VALUE;
//     }
    
//     public boolean check(int i, int j, int R, int C) {
//         if (i < 0 || i >= R || j < 0 || j >= C)
//             return false;
//         return true;
//     }

    
class Solution {
    public int cherryPickup(int[][] grid) {
        return cherryPickup(grid, 0, 0, grid[0].length - 1, new Integer[grid.length][grid[0].length][grid[0].length]);
    }
    
    public int cherryPickup(int[][] grid, int i, int j1, int j2, Integer[][][] cache) {
        if(j1 == grid[0].length || j1 < 0 || j2 == grid[0].length || j2 < 0) {
            return 0;
        }
        if(i == grid.length - 1) {
            if(j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];    
            }            
        } 
        
        if(cache[i][j1][j2] == null) {

            int max = cherryPickup(grid, i + 1, j1 - 1, j2 - 1, cache);
            max = Math.max(max, cherryPickup(grid, i + 1, j1 - 1, j2, cache));
            max = Math.max(max, cherryPickup(grid, i + 1, j1 - 1, j2 + 1, cache));

            max = Math.max(max, cherryPickup(grid, i + 1, j1, j2 - 1, cache));
            max = Math.max(max, cherryPickup(grid, i + 1, j1, j2, cache));
            max = Math.max(max, cherryPickup(grid, i + 1, j1, j2 + 1, cache));

            max = Math.max(max, cherryPickup(grid, i + 1, j1 + 1, j2 - 1, cache));
            max = Math.max(max, cherryPickup(grid, i + 1, j1 + 1, j2, cache));
            max = Math.max(max, cherryPickup(grid, i + 1, j1 + 1, j2 + 1, cache));

            if(j1 == j2) {
                cache[i][j1][j2] = max + grid[i][j1];
            } else {
                cache[i][j1][j2] =  max + grid[i][j1] + grid[i][j2];    
            }
        }
        return cache[i][j1][j2];
    }
}