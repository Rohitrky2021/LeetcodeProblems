class Solution{
    public int minPairSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int l=0,r=n-1;
        int maxi=0;

        while(l<r){
          maxi=Math.max(maxi,nums[l]+nums[r]);
          l++;
          r--;
        }
        return maxi;
    }
}


class Solution1 {
    public int minPairSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        return Math.max(nums[0]+nums[n-1],nums[1]+nums[n-2]);
    }
}