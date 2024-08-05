import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        // Edge case
        if (nums == null || nums.length < 2) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // Maintain a sliding window of size indexDiff
            if (i > indexDiff) {
                set.remove((long) nums[i - indexDiff - 1]);
            }

            // Find the closest number greater than or equal to nums[i] - valueDiff
            Long floor = set.floor((long) nums[i] + valueDiff);
            if (floor != null && floor >= (long) nums[i] - valueDiff) {
                return true;
            }

            set.add((long) nums[i]);
        }
        return false;
    }
}
