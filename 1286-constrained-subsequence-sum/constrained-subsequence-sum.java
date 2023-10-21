import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxSum = nums[0];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && i - deque.peekFirst() > k) {
                deque.pollFirst();
            }

            dp[i] = Math.max(nums[i], nums[i] + (deque.isEmpty() ? 0 : dp[deque.peekFirst()]));
            maxSum = Math.max(maxSum, dp[i]);

            while (!deque.isEmpty() && dp[i] >= dp[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }

        return maxSum;
    }
}


// public int minCostClimbingStairs(int[] cost, int k) {
//     int n = cost.length;
//     return minCost(cost, n - 1, k);
// }

// private int minCost(int[] cost, int n, int k) {
//     if (n < 0)
//         return 0;
//     if (n == 0 || n == 1)
//         return cost[n];

//     int minCost = Integer.MAX_VALUE;
//     for (int i = 1; i <= k && n - i >= 0; i++) {
//         int currentCost = cost[n] + minCost(cost, n - i, k);
//         minCost = Math.min(minCost, currentCost);
//     }
//     return minCost;
// }

// // Recursive Top Down - O(2^n) Time Limit Exceeded
// public int minCostClimbingStairs(int[] cost) {
// 	int n = cost.length;
// 	return Math.min(minCost(cost, n-1), minCost(cost, n-2));
// }

// int max=Integer.MIN_VALUE;
// private int minCost(int[] cost, int n) {
// 	if (n < 0) return 0;
// 	if (n==0 || n==1) return cost[n];
    
//     for(int i=0;i<k;i++){
//         max=Math.max(max,minCost(cost, n-i));
//     }
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

