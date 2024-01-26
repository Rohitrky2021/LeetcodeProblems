import java.util.Arrays;

class Solution {
    int[][] dp;

    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        dp = new int[m + 1][n + 1];
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }
        return lcs(s1, s2, m, n);
    }

    public int lcs(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) return 0;

        if (dp[m][n] != -1) return dp[m][n];

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return dp[m][n] = 1 + lcs(s1, s2, m - 1, n - 1);
        } else {
            return dp[m][n] = Math.max(lcs(s1, s2, m, n - 1), lcs(s1, s2, m - 1, n));
        }
    }
}
