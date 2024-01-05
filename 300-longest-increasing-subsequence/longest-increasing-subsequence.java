import java.util.Arrays;
import java.util.Scanner;

class Solution {
 
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int mx = 0;

        for (int i = 0; i < dp.length; i++) {
            int max = 0;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }

            dp[i] = max + 1;

            if (dp[i] > mx) {
                mx = dp[i];
            }
        }

        return mx;
    }
}
