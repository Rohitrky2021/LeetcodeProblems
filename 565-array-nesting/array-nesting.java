import java.util.HashSet;

class Solution {
    public int arrayNesting(int[] nums) {
        // your implementation here
        int ans = 0;

        var hs = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (hs.contains(nums[i])) {
                continue;
            }
            int c = i;
            int count = 0; // declare and initialize count here
            while (!hs.contains(nums[c])) {
                hs.add(nums[c]); // add to set to avoid revisiting
                c = nums[c];
                count++;
            }
            ans = Math.max(count, ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,1,2}; // example input
        int result = solution.arrayNesting(nums);
        System.out.println("Result: " + result);
    }
}