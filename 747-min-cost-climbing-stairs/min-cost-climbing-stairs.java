class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for (int i = 2; i <= n; i++) {
            int currentCost = (i == n) ? 0 : cost[i]; // Last step has cost 0
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + currentCost;
        }
        
        return dp[n];
    }
}

// // Recursive Top Down - O(2^n) Time Limit Exceeded
// public int minCostClimbingStairs(int[] cost) {
// 	int n = cost.length;
// 	return Math.min(minCost(cost, n-1), minCost(cost, n-2));
// }
// private int minCost(int[] cost, int n) {
// 	if (n < 0) return 0;
// 	if (n==0 || n==1) return cost[n];
// 	return cost[n] + Math.min(minCost(cost, n-1), minCost(cost, n-2));
// }

// // Top Down Memoization - O(n) 1ms
// int[] dp;
// public int minCostClimbingStairs(int[] cost) {
// 	int n = cost.length;
// 	dp = new int[n];
// 	return Math.min(minCost(cost, n-1), minCost(cost, n-2));
// }
// private int minCost(int[] cost, int n) {
// 	if (n < 0) return 0;
// 	if (n==0 || n==1) return cost[n];
// 	if (dp[n] != 0) return dp[n];
// 	dp[n] = cost[n] + Math.min(minCost(cost, n-1), minCost(cost, n-2));
// 	return dp[n];
// }