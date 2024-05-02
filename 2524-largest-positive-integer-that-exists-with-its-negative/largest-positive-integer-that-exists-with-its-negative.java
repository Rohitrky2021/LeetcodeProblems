class Solution {
    public int findMaxK(int[] nums) {

        int fr[]=new int[1010];

        for(int i:nums){
            // i=Math.abs(i);
            if(i>0 && (fr[i]==2 || fr[i]==5)) {
                continue;
            } else if(i>0) {
                fr[i]+=2;
            }

            if(i<0 && (fr[Math.abs(i)]==3 || fr[Math.abs(i)]==5)) { // Added parentheses here
                continue;
            } else if(i<0) {
                fr[-i]+=3;
            }

        }

        int ans=0;

        for(int i=0;i<nums.length;i++) {
            if(fr[Math.abs(nums[i])]==5) ans=Math.max(ans,nums[i]);
        }

        return ans==0?-1:ans;
        
    }
}
