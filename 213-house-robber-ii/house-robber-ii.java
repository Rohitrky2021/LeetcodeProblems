class Solution2 {
 

    public int rob(int[] nums) {
        if (nums.length < 1) return 0;
        if (nums.length < 2) return nums[0];

        int[] Rub = new int[nums.length];
        Rub[0] = nums[0];
        Rub[1] = Math.max(nums[1], Rub[0]);

        for (int i = 2; i < nums.length; i++) {
            Rub[i] = Math.max(Rub[i - 2] + nums[i], Rub[i - 1]);
        }

        return Rub[nums.length - 1];
    }
}



 

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[0];
        }

        int dp1[] = new int[n]; // Include the first house, exclude the last house
        int dp2[] = new int[n]; // Exclude the first house, include the last house

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int result1 = profit(nums, 0, n - 2, dp1);
        int result2 = profit(nums, 1, n - 1, dp2);

        return Math.max(result1, result2);
    }

    public int profit(int nums[], int start, int end, int[] dp) {
        if (start > end) return 0;

        if (dp[start] != -1) return dp[start];

        int sum = 0;

        int op2 = profit(nums, start + 1, end, dp);
        int op1 = profit(nums, start + 2, end, dp) + nums[start];

        sum = Math.max(op2, op1);

        dp[start] = sum;

        return dp[start];
    }
}
