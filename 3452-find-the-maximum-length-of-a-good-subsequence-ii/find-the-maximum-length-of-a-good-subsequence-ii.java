class Solution1 {
   public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][][] dp = new int[n + 1][n + 1][k + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int prev = -1; prev < n; prev++) {
                int prevIndex = prev + 1;
                for (int remainingK = 0; remainingK <= k; remainingK++) {

                    int not = dp[i + 1][prevIndex][remainingK];

                    int take = 0, takee = 0;

                    if (remainingK > 0) {

                        if (prev == -1 || nums[i] != nums[prev]) {

                            take = 1 + dp[i + 1][i + 1][remainingK - 1];
                        }
                    }

                    if (prev == -1 || nums[i] == nums[prev]) {
                        takee = 1 + dp[i + 1][i + 1][remainingK];
                    }

                    dp[i][prevIndex][remainingK] = Math.max(not, Math.max(take, takee));
                }
            }
        }

        return dp[0][0][k];
    }
}

class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return 0;

        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; ++i) dp[i][0] = 1;

        int res = 1;
        for (int j = 0; j <= k; ++j) {
            int max1 = 1;
            Map<Integer, Integer> numMap = new HashMap<>();
            numMap.put(nums[0], 0);

            for (int i = 1; i < n; ++i) {
                dp[i][j] = 1;
                if (i > 0 && j > 0) max1 = Math.max(max1, dp[i - 1][j - 1] + 1);
                dp[i][j] = Math.max(dp[i][j], max1);

                if (numMap.containsKey(nums[i])) {
                    dp[i][j] = Math.max(dp[i][j], dp[numMap.get(nums[i])][j] + 1);
                }

                numMap.put(nums[i], i);
                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }
}