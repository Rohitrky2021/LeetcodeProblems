class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int lastset = 0;  // Start at 0, not 1

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] && nums[i] != 0) {  // Ensure nonzero numbers are combined
                nums[i - 1] *= 2;  // Double the previous number
                nums[i] = 0;  // Make current number zero
            }
        }

        // Shift all nonzero numbers to the left
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[lastset++] = nums[i];
            }
        }

        // Fill remaining spaces with zeros
        while (lastset < n) {
            nums[lastset++] = 0;
        }

        return nums;
    }
}
