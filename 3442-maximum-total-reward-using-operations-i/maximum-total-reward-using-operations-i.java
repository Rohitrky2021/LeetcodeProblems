import java.util.Arrays;

class Solution {
    private int[][] dp;
    private int n;

    public int maxTotalReward(int[] rewardValues) {
        n = rewardValues.length;
        
        // Initialize the DP array with -1
        dp = new int[n][4005];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Sort the reward values
        Arrays.sort(rewardValues);

        // Start the recursive function
        return maxTotalRewardUtil(rewardValues, 0, 0);
    }

    private int maxTotalRewardUtil(int[] rewardValues, int index, int currentSum) {
        // Base case: if we have considered all items
        if (index == n) {
            return 0;
        }

        // If the value is already calculated, return it
        if (dp[index][currentSum] != -1) {
            return dp[index][currentSum];
        }

        // Option 1: Do not pick the current item
        int noPick = maxTotalRewardUtil(rewardValues, index + 1, currentSum);

        // Option 2: Pick the current item (if it fits the constraint)
        int pick = 0;
        if (currentSum < rewardValues[index] && currentSum + rewardValues[index] <= 4005) {
            pick = rewardValues[index] + maxTotalRewardUtil(rewardValues, index + 1, currentSum + rewardValues[index]);
        }

        // Store the result in the DP array
        dp[index][currentSum] = Math.max(pick, noPick);

        return dp[index][currentSum];
    }
}
