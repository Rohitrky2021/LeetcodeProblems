class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length,c=0;
        for(int i=0;i<n;i++){
            nums[i]=Math.abs(nums[i]);
        }

        Arrays.sort(nums);

        for(int i:nums){
            nums[c++]=i*i;
        }

        return nums;
        
    }
}