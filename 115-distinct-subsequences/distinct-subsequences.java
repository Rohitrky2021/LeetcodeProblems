class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        
        // Initialize the DP array with -1 values
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return memo(s, t, n - 1, m - 1, dp);
    }

    public static int memo(String s, String t, int i, int j, int[][] dp) {
        if (j < 0) return 1;
        if (i < 0) return 0;
        
        // Check if the subproblem has been solved previously
        if (dp[i][j] != -1) return dp[i][j];
        
        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = memo(s, t, i - 1, j - 1, dp) + memo(s, t, i - 1, j, dp);
        } else {
            return dp[i][j] = memo(s, t, i - 1, j, dp);
        }
    }
}
