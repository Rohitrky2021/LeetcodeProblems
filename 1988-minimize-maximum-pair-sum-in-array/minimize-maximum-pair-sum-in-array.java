class Solution {
    public int minPairSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int l=0,r=n-1;
        int maxi=- (int)1e5;

        while(l<r){
          maxi=Math.max(maxi,nums[l]+nums[r]);
          l++;
          r--;
        }
        return maxi;
    }
}