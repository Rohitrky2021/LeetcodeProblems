class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int res = 1;
        int curLen = 1;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]) {
                if(nums[i] == nums[i - 1] + 1) {
                    curLen++;
                    res = Math.max(res, curLen);
                } else {
                    curLen = 1;
                }
            }
        }


        return res;
    }
}
class Solution1 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int lcs = 0;
        int ans = Integer.MIN_VALUE;
        HashSet<Integer> s = new HashSet<>();
        Arrays.sort(nums);
        
        for (int x : nums) {
            s.add(x);
        }

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            // If the current element is the start of a sequence
            if (!s.contains(current - 1)) {
                int next = current + 1;
                while (s.contains(next)) {
                    next++;
                }
                lcs = Math.max(lcs, next - current);
            }
            ans = Math.max(ans, lcs);
        }

        return ans;
    }
}
