import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, (long) target, 4, 0);
    }

    private List<List<Integer>> kSum(int[] nums, long target, int k, int index) {
        List<List<Integer>> res = new ArrayList<>();

        if (index >= nums.length) {
            return res;
        }

        if (k == 2) {
            int left = index, right = nums.length - 1;
            while (left < right) {
                long sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(nums[left]);
                    pair.add(nums[right]);
                    res.add(pair);
                    while (left < right && nums[left] == pair.get(0)) left++;
                    while (left < right && nums[right] == pair.get(1)) right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        } else {
            for (int i = index; i < nums.length - k + 1; i++) {
                if (i > index && nums[i] == nums[i - 1]) {
                    continue;
                }
                List<List<Integer>> subResult = kSum(nums, target - nums[i], k - 1, i + 1);
                for (List<Integer> list : subResult) {
                    list.add(0, nums[i]);
                    res.add(new ArrayList<>(list));
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }

        return res;
    }
}
