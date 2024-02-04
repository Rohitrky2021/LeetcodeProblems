class Solution {
    public int[] numberGame(int[] nums) {
        int n=nums.length;
        
        int ans[]=new int[n];
        
        Arrays.sort(nums);
        int i=0;
        
        n=n/2;
        while(  n>0){
            ans[i]=nums[i+1];
            ans[i+1]=nums[i];
            
            i+=2;
            n--;
        }
        
        return ans;
    }
}