class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0;
        int right;
        int maxLength = 0;

        for (right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            
            // Ensure the invariant |max - min| <= limit is satisfied
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            
            // Update maximum length of subarray
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
