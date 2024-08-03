class Solution {
    public int minFlips(int[][] grid) {
       int n = grid.length;
        int m = grid[0].length;

        int c1=0,r1=0;
        
        // Case 1: Cutting through the middle column
        int[][] resultCol = new int[n][m / 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                resultCol[i][j] = grid[i][j] + grid[i][m - 1 - j];
                if(resultCol[i][j]==1)c1++;
            }
        }
        
        // Case 2: Cutting through the middle row
        int[][] resultRow = new int[n / 2][m];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m; j++) {
                resultRow[i][j] = grid[i][j] + grid[n - 1 - i][j];
                if(resultRow[i][j]==1)r1++;
            }
        }

        int ans=Math.min(c1, r1);
        
        // Return the results as a 3D array for convenience
        return ans;  
    }
}