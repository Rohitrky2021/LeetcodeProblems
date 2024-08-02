class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];

        // Copy nums array twice to handle circular array
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }

        // Count number of ones in the array
        int ones = 0;
        for (int num : nums) {
            if (num == 1) {
                ones++;
            }
        }

        // Edge case: if no ones, no swaps needed
        if (ones == 0) {
            return 0;
        }

        // Initial window of size 'ones'
        int curr = 0;
        for (int i = 0; i < ones; i++) {
            curr += ans[i];
        }
        int max = curr;

        // Sliding window to find maximum number of ones in any window of size 'ones'
        for (int i = 1; i < n; i++) {
            curr = curr - ans[i - 1] + ans[i + ones - 1];
            max = Math.max(curr, max);
        }

        return ones - max;
    }
}
