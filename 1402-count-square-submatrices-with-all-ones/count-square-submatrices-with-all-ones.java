class Solution1 {
    public int countSquares(int[][] matrix) {
        // Get dimensions of the matrix
        int n = matrix.length;    // number of rows
        int m = matrix[0].length; // number of columns
        
        // Create a DP table with same dimensions as matrix
        int[][] dp = new int[n][m];
        
        // Variable to store total count of squares
        int ans = 0;
        
        // Initialize first column of DP table
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0];
            ans += dp[i][0];
        }
        
        // Initialize first row of DP table
        for (int j = 1; j < m; j++) {
            dp[0][j] = matrix[0][j];
            ans += dp[0][j];
        }
        
        // Fill the DP table for remaining cells
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]);
                }
                ans += dp[i][j];
            }
        }
        
        return ans;
    }
}

class Solution2 {
    public int countSquares(int[][] matrix) {
    int dp[][] = new int[matrix.length+1][matrix[0].length+1];
    int ans = 0; 
    for(int i=0; i<matrix.length; i++)
    {
      for(int j=0; j<matrix[0].length; j++)
      {
        if(matrix[i][j]==1)
        dp[i+1][j+1] = 1 + Math.min(dp[i][j], Math.min(dp[i+1][j], dp[i][j+1]));
        ans += dp[i+1][j+1];
      }  
    }  
    return ans;  
    }
}

class Solution {
    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }   
        int row = matrix.length;
        int col = matrix[0].length;
        int rst = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (matrix[i][j] == 1) {
                    int left = getNum(matrix, i - 1, j);
                    int up = getNum(matrix, i, j - 1);
                    int dia = getNum(matrix, i - 1, j - 1);
                    matrix[i][j] += Math.min(Math.min(left, up), dia);
                    rst += matrix[i][j];
                }
            }
        }
        return rst;
    }
    private int getNum(int[][] matrix, int x, int y) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[x].length) {
            return 0;
        }
        return matrix[x][y];
    }
}