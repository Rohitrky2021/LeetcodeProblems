class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0,ans=0;
        for(int i:nums){
            if(i==1)max++;
            else max=0;

            ans=Math.max(max,ans);

        }
        return ans;
    }
}