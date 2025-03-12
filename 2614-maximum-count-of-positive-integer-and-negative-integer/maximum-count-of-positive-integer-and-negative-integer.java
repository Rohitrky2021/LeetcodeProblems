class Solution {

    public int maximumCount(int[] nums) {
        int pos = 0, neg = 0;

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if(nums[i]<0)neg++;
            if(nums[i]>0)pos++;
        }

        return Math.max(pos,neg);
    }
}
