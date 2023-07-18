class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return calculateWays(nums, target, 0);
    }

    private int calculateWays(int[] nums, int target, int i) {
        if (i == nums.length) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int sumWithAddition = calculateWays(nums, target - nums[i], i + 1);
        int sumWithSubtraction = calculateWays(nums, target + nums[i], i + 1);

        return sumWithAddition + sumWithSubtraction;
    }
}
