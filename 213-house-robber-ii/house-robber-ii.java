 
class Solution {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        return Math.max(
            robHelper(nums, 0, nums.length - 2),
            robHelper(nums, 1, nums.length - 1)
        );
    }

    public int robHelper(int[] nums, int start, int end) {
        int rob1 = 0;
        int rob2 = 0;
        for (int i = start; i <= end; i++) {
            int temp = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}




 

class Solution3 {
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
