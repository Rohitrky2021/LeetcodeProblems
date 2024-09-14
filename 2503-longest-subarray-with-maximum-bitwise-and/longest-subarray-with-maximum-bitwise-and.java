class Solution {
    public int longestSubarray(int[] nums) {
        // Find the maximum value in the array
        int max = nums[0];
        int n = nums.length;

        // Find the maximum value in the array
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        // Now, calculate the longest subarray where all elements are equal to 'max'
        int longest = 0;
        int currentLength = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == max) {
                currentLength++;
                longest = Math.max(longest, currentLength);
            } else {
                currentLength = 0; // Reset the current length when the value is not max
            }
        }

        return longest;
    }
}
