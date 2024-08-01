import java.util.Arrays;

class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        int totalSum = Arrays.stream(nums).sum();
        Arrays.sort(nums);

        // Early exit condition
        boolean possible = false;
        for (int i = 1; i <= n / 2; i++) {
            if (totalSum * i % n == 0) {
                possible = true;
                break;
            }
        }
        if (!possible) return false;

        // DP set to hold possible sums
        boolean[][] dp = new boolean[n + 1][totalSum + 1];
        dp[0][0] = true;

        for (int num : nums) {
            for (int i = n; i >= 1; i--) {
                for (int j = totalSum; j >= num; j--) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - num];
                }
            }
        }

        // Check for any valid subset sum
        for (int i = 1; i <= n / 2; i++) {
            if (totalSum * i % n == 0 && dp[i][totalSum * i / n]) {
                return true;
            }
        }
        return false;
    }
}
