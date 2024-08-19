class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0; // 1 'A' requires 0 operations

        for (int i = 2; i <= n; i++) {
            dp[i] = i; // Start with the worst case: all single additions (i-1 pastes)
            for (int j = i / 2; j > 0; j--) {
                if (i % j == 0) {  // j is a divisor of i
                    dp[i] = dp[j] + (i / j);
                    break;
                }
            }
        }
        
        return dp[n];
    }
}
