class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize closestSum with the sum of the first three elements.
        int minDiff = Math.abs(closestSum - target); // Initialize minDiff with the absolute difference between closestSum and target.

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int curr = nums[i] + nums[j] + nums[k]; // Calculate the current sum.
                    int diff = Math.abs(curr - target); // Calculate the difference between the current sum and the target.

                    if (diff < minDiff) { // If the difference is smaller than the current minimum difference,
                        minDiff = diff; // update the minimum difference,
                        closestSum = curr; // and update the closest sum.
                    }
                }
            }
        }

        return closestSum;
    }
}
