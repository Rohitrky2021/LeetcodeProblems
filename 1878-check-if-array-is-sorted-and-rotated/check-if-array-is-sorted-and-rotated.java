class Solution {
    public boolean check(int[] nums) {
        int prev=0;
        int next=0;
        int n=nums.length,count=0;

        for(int i=0;i<n-1;i++){
            if(nums[i]<=nums[i+1]){
                
            }else{
                count++;    }
        }

        return ((count==1 && nums[0]>=nums[n-1]) || count==0)  ;
        
    }
}