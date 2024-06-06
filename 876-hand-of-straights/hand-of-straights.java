class Solution {
    public boolean isNStraightHand(int[] nums, int k) {
         if (nums.length % k != 0) return false;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);

        for (int num: nums) {
            if (map.get(num) == 0) continue;
            for (int i = 0; i < k; i++) {
                int curr = num + i;
                if (map.getOrDefault(curr, 0) == 0) return false;
                else map.put(curr, map.get(curr) - 1);
            }
        }
        return true;
    }
}

 





















