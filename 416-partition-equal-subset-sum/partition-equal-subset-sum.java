class Solution {
    public boolean canPartition(int[] nums) {
     int sum=Arrays.stream(nums).sum();
     int s2=sum/2;
     int n=nums.length;

     if(sum%2!=0)return false;

    return isSubsetSum(n,nums,sum/2);
 




    }
        static boolean[][] dp;

      static Boolean isSubsetSum(int N, int arr[], int sum) {
        boolean[][] dp = new boolean[N + 1][sum + 1];
        // code here
        for (int i = 0; i < N + 1; i++)
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0)
                    dp[i][j] = false;

                if (j == 0)
                    dp[i][j] = true;

                if (i == 0 && j == 0)
                    dp[i][j] = true;
            }

        for (int i = 1; i < N + 1; i++)
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }

                else if (arr[i - 1] > j)

                {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        return dp[N][sum];
    }
}



class Solution1 {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        // find sum of all array elements
        for (int num : nums) {
            totalSum += num;
        }
        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if (totalSum % 2 != 0) return false;
        int subSetSum = totalSum / 2;
        int n = nums.length;
        Boolean[][] memo = new Boolean[n + 1][subSetSum + 1];
        return dfs(nums, n - 1, subSetSum, memo);
    }

    public boolean dfs(int[] nums, int n, int subSetSum, Boolean[][] memo) {
        // Base Cases
        if (subSetSum == 0)
            return true;
        if (n == 0 || subSetSum < 0)
            return false;
        // check if subSetSum for given n is already computed and stored in memo
        if (memo[n][subSetSum] != null)
            return memo[n][subSetSum];
        boolean result = dfs(nums, n - 1, subSetSum - nums[n - 1], memo) ||
                dfs(nums, n - 1, subSetSum, memo);
        // store the result in memo
        memo[n][subSetSum] = result;
        return result;
    }
}