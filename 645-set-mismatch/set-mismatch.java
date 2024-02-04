import java.util.Arrays;

class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[2];
        int n = nums.length;
        
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                result[0] = nums[i]; // Duplicate number
                break;
            }
        }
        
        long sum = (long) n * (n + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        
        result[1] = (int) (result[0] + sum); // Missing number
        
        return result;
    }
}
