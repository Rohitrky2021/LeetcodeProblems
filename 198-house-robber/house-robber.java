import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int dp[] = new int[n];

        Arrays.fill(dp, -1);

        return profit(nums, 0, dp);
    }

    public int profit(int nums[], int i, int[] dp) {
        if (i >= nums.length) return 0;

        if (dp[i] != -1) return dp[i];

        int sum = 0;

        int op2 = profit(nums, i + 1, dp);
        int op1 = profit(nums, i + 2, dp) + nums[i];

        sum = Math.max(op2, op1);

        dp[i] = sum;

        return dp[i];
    }
}
