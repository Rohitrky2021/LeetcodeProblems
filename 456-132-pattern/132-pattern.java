import java.util.ArrayDeque;

class Solution {

    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        ArrayDeque<Integer> hs = new ArrayDeque<>();
        int n = nums.length;
        int[] minLeft = new int[n];

        minLeft[0] = nums[0];
        for (int i = 1; i < n; i++) {
            minLeft[i] = Math.min(minLeft[i - 1], nums[i]);
        }

        for (int j = n - 1; j >= 0; j--) {
            while (!hs.isEmpty() && hs.peek() < nums[j]) {
                if (hs.pop() > minLeft[j]) {
                    return true;
                }
            }
            hs.push(nums[j]);
        }

        return false;
    }
}
