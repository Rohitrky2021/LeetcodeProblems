import java.util.HashSet;

class Solution {
    public int arrayNesting(int[] nums) {
        // your implementation here
        int ans = 0;

        var hs = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (hs.contains(nums[i])) { // mtlb ye already kisi path m aagya tha mtlb merese tho chortaa he hoga 
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
        int[] nums = {5, 4, 0, 3, 1, 6, 2}; // example input
        int result = solution.arrayNesting(nums);
        System.out.println("Result: " + result);
    }
}