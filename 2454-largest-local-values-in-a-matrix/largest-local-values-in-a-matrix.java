
class Solution {
    public int[][] largestLocal(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int ans[][]=new int[m-2][n-2];

        for(int i=1;i<m-1;i++){
            for (int j = 1; j < n-1; j++) {
                ans[i-1][j-1]=check( grid,i, j);
            }
        }
        return ans;
    }

    public int check(int grid[][], int i, int j) {
        int max = grid[i][j];
        
        // Check the top row
        for (int col = j - 1; col <= j + 1; col++) {
            if (col >= 0 && col < grid[0].length && grid[i - 1][col] > max) {
                max = grid[i - 1][col];
            }
        }
        
        // Check the bottom row
        for (int col = j - 1; col <= j + 1; col++) {
            if (col >= 0 && col < grid[0].length && grid[i + 1][col] > max) {
                max = grid[i + 1][col];
            }
        }
        
        // Check the left and right borders of the center
        if (grid[i][j - 1] > max) {
            max = grid[i][j - 1];
        }
        if (grid[i][j + 1] > max) {
            max = grid[i][j + 1];
        }
        
        return max;
    }
    
}