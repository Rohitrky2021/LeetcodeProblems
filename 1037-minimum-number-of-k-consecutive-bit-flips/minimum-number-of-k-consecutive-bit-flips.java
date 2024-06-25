class Solution {

    public int minKBitFlips(int[] arr, int k) {
        int n = arr.length;
        int operations = 0;
        int[] flip = new int[n];
        int flipCount = 0;

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                flipCount ^= flip[i - k];
            }
            if ((arr[i] ^ flipCount) == 0) {
                if (i + k > n) {
                    return -1; // Not enough elements to flip
                }
                flipCount ^= 1;
                flip[i] = 1;
                operations++;
            }
        }

        return operations;
    }

    public int minKBitFlips2(int[] nums, int k) {
        int len = nums.length, flip = 0;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            int previous = i - k >= 0 ? dp[i - k] : 0;
            int curr = (nums[i] + flip - previous) % 2;
            if (curr == 0) {
                if (i + k > len) {
                    return -1;
                }
                flip++;
            }
            dp[i] = flip;
        }
        return dp[len - 1];
    }
}
