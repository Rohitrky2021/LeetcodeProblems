// class Solution {
//     public int paintWalls(int[] cost, int[] time) {
        
//     }
// }
// class Solution {
//     public int paintWalls(int[] cost, int[] time) {
//         int totalCost = 0;
//         int currentTime = 0;

//         for (int i = 0; i < cost.length; i++) {
//             if (currentTime < time[i]) {
//                 // The paid painter is faster, so we use them
//                 totalCost += cost[i];
//                 currentTime += time[i];
//             } else {
//                 // The paid painter is occupied, so we use the free painter
//                 totalCost += cost[i];
//                 currentTime++;
//             }
//         }

//         return totalCost;
//     }
// }
// class Solution {
//     public int paintWalls(int[] cost, int[] time) {
//         int n = cost.length;
//         int[][] dp = new int[n][2];

//         dp[0][0] = cost[0];
//         dp[0][1] = 0;

//         for (int i = 1; i < n; i++) {
//             dp[i][0] = Math.min(dp[i-1][0] + cost[i], dp[i-1][1]);
//             dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1] + cost[i]);
//         }

//         return Math.min(dp[n-1][0], dp[n-1][1]);
//     }
// }

class Solution {
    int[][] memo;
    int n;
    
    public int paintWalls(int[] cost, int[] time) {
        n = cost.length;
        memo = new int[n][n + 1];
        return dp(0, n, cost, time);
    }
    
    public int dp(int i, int remain, int[] cost, int[] time) {
        if (remain <= 0) {
            return 0;
        }
        
        if (i == n) {
            return (int) 1e9;
        }
        
        if (memo[i][remain] != 0) {
            return memo[i][remain];
        }
        
        int paint = cost[i] + dp(i + 1, remain - 1 - time[i], cost, time);
        int dontPaint = dp(i + 1, remain, cost, time);
        memo[i][remain] = Math.min(paint, dontPaint);
        return memo[i][remain];
    }
}