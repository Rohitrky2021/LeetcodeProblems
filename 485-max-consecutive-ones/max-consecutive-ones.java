class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0,ans=0;
        for(int i:nums){
            if(i==0)max=0;
            else max++;

            ans=Math.max(max,ans);

        }
        return ans;
    }
}