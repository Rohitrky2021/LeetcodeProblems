// public int minFallingPathSum(int[][] A) {
//   for (int i = 1; i < A.length; ++i)
//     for (int j = 0; j < A.length; ++j)
//       A[i][j] += Math.min(A[i - 1][j], Math.min(A[i - 1][Math.max(0, j - 1)], A[i - 1][Math.min(A.length - 1, j + 1)]));
//   return Arrays.stream(A[A.length - 1]).min().getAsInt();
// }       


class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int m = matrix.length, n = matrix[0].length;
        int result = Integer.MAX_VALUE;
        
        int[][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        
        for(int i = 0; i < n; i++)
            result = Math.min(result, solve(m - 1, i, matrix, dp));
        
        return result;
    }
    
    private int solve(int m, int n, int[][] matrix, int[][] dp){
        
        if(n < 0 || n >= matrix[m].length) return Integer.MAX_VALUE;
        
        if(m == 0) return dp[m][n] = matrix[0][n];
        
        if(dp[m][n] != Integer.MAX_VALUE) return dp[m][n];
        
        int up = solve(m - 1, n, matrix, dp);
        int left = solve(m - 1, n - 1, matrix, dp);
        int right = solve(m - 1, n + 1, matrix, dp);
        
        return dp[m][n] = Math.min(Math.min(left, right), up) + matrix[m][n];
        
    }
}