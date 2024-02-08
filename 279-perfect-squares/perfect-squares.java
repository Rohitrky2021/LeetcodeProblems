class Solution {
    public int numSquares(int n) {
          int[] perfectSquares = fillPerfectSquares(n);

        // Applying Unbounded Knapsack on perfectSquares array
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (perfectSquares[j * j] == 1) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
        }

        return dp[n];
    }

      public static int[] fillPerfectSquares(int n) {
        // Create an array to store whether a number is a perfect square or not
        int[] perfectSquares = new int[n + 1];

        // Mark all numbers as non-perfect squares initially
        Arrays.fill(perfectSquares, 0);

        // Mark perfect squares
        for (int i = 1; i * i <= n; i++) {
            perfectSquares[i * i] = 1;
        }

        return perfectSquares;
    }
}