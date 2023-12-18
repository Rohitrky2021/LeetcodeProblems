class Solution {
    public int maxProductDifference(int[] nums) {
        int max=1,n=nums.length;
         

        Arrays.sort(nums);

        return nums[n-1]*nums[n-2]-nums[0]*nums[1];

        
    }
}