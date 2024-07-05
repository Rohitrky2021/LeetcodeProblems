class Solution {
    public int minDifference(int[] nums) {
        
        int n=nums.length-1;

        // 1 2 
        // 2 1 
        // 3 0
        // 0 3 

        Arrays.sort(nums);
        if(n<=3){
            return 0;
        }
        int ans=Integer.MAX_VALUE;

         ans=Math.min(nums[n-3]-nums[0],ans);
         ans=Math.min(nums[n-2]-nums[1],ans);
         ans=Math.min(nums[n-1]-nums[2],ans);
         ans=Math.min(nums[n]-nums[3],ans);

        return ans;


        
    }
}