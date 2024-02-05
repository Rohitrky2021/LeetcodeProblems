import java.util.Arrays;

class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        return help(jobDifficulty, d, 0, new Integer[jobDifficulty.length][d + 1]);
    }

    public int help(int[] arr, int k, int idx, Integer[][] memo) {
        if (k == 1) {
            int max = Integer.MIN_VALUE;
            for (int i = idx; i < arr.length; i++) {
                max = Math.max(max, arr[i]);
            }
            return max;
        }

        if (memo[idx][k] != null)
            return memo[idx][k];

        int max = Integer.MIN_VALUE;
        int minDifficulty = Integer.MAX_VALUE;

        for (int i = idx; i <= arr.length - k; i++) {
            max = Math.max(max, arr[i]);
            int nextDifficulty = help(arr, k - 1, i + 1, memo);
            if (nextDifficulty != -1)
                minDifficulty = Math.min(minDifficulty, max + nextDifficulty);
        }

        memo[idx][k] = (minDifficulty == Integer.MAX_VALUE) ? -1 : minDifficulty;
        return memo[idx][k];
    }
}
