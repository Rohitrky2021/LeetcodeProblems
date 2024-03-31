
class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        if (k <= 0)
            return 1;
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;

        HashMap<Integer, Integer> bitCounts = new HashMap<>();

        int left = 0;
        int curr = 0;

        for (int right = 0; right < n; right++) {
            curr |= nums[right];
            updateBitCounts(nums[right], bitCounts, 1); // Update bit counts for the new element
            while (curr >= k) {
                minLength = Math.min(minLength, right - left + 1);
                updateBitCounts(nums[left], bitCounts, -1); // Update bit counts for the removed element
                curr = convertBitCountsToNumber(bitCounts);
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    private void updateBitCounts(int num, HashMap<Integer, Integer> bitCounts, int delta) {
        for (int i = 0; i < 32; i++) { // Assuming 32-bit integers
            if ((num & (1 << i)) != 0) {
                bitCounts.put(i, bitCounts.getOrDefault(i, 0) + delta);
            }
        }
    }

    private int convertBitCountsToNumber(HashMap<Integer, Integer> bitCounts) {
        int number = 0;
        for (int i = 31; i >= 0; i--) { // Assuming 32-bit integers
            if (bitCounts.containsKey(i) && bitCounts.get(i) > 0) {
                number |= (1 << i); // Set the ith bit in the number
            }
        }
        return number;
    }
}
