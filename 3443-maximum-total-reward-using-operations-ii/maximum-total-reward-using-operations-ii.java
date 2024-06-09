import java.util.Arrays;

class Solution {
    public int maxTotalReward(int[] rewards) {
        // Sort the rewards array
        Arrays.sort(rewards);
        int max = rewards[rewards.length - 1];

        // Initialize the dp array with boolean values
        boolean[] dp = new boolean[max + 1];
        dp[0] = true;

        // Iterate through the rewards array
        for (int i = 0; i < rewards.length - 1; i++) {
            for (int j = rewards[i]; j <= max && j - rewards[i] < rewards[i]; j++) {
                dp[j] = dp[j] || dp[j - rewards[i]];
            }
        }

        // Find the maximum total reward
        for (int i = max - 1; i >= 0; i--) {
            if (dp[i]) return max + i;
        }

        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] rewards = {1, 2, 3, 4, 6};
        System.out.println(sol.maxTotalReward(rewards)); // Output the maximum total reward
    }
}
