import java.util.Arrays;
import java.util.TreeMap;

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) return false;

        Arrays.sort(nums);

        TreeMap<Integer, Integer> countMap = new TreeMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (countMap.get(num) > 0) {
                for (int i = 0; i < k; i++) {
                    int nextNum = num + i;
                    if (countMap.getOrDefault(nextNum, 0) <= 0) {
                        return false; // If the consecutive number doesn't exist or it's already used up, return false
                    }
                    countMap.put(nextNum, countMap.get(nextNum) - 1); // Decrease count for the consecutive number
                }
            }
        }

        return true;
    }
}
