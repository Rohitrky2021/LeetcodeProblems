class Solution1{
    public long maximumTotalCost(int[] nums) {
        int n = nums.length;
        long addResult = nums[0];
        long subResult = nums[0];
        for (int i = 1; i < n; i++) {
            long tempAdd = Math.max(addResult, subResult) + nums[i];
            long tempSub = addResult - nums[i];

            addResult = tempAdd;
            subResult = tempSub;
        }
        return Math.max(addResult, subResult);
    }
}

class Solution2 {
    public long maximumTotalCost(int[] nums) {
        int n = nums.length;
        long ans = 0;
        long addResult = nums[0]+solve(1,0,nums,ans);    
        return addResult;
    }

      public long solve(int i, int fresh,int[] nums,long ans){// fresh ==0 mean merse se pehle waale ne fresh shuru kiya tha 
        if(i==nums.length){
            return 0;
        }
        long take=0,subtrac=0;

        if(fresh==0){
            take=nums[i]+solve(i+1,0,nums,ans);
            subtrac=-nums[i]+solve(i+1,1,nums,ans);
        }else{
            take+=nums[i]+solve(i+1,0,nums,ans);
            return take;
        }

        ans=Math.max(take,subtrac);

        return ans;
      }
}
 
class Solution {
    public long maximumTotalCost(int[] nums) {
        int n = nums.length;
        Map<String, Long> memo = new HashMap<>();
        long ans = nums[0] + solve(1, 0, nums, memo);
        return ans;
    }

    private long solve(int i, int fresh, int[] nums, Map<String, Long> memo) {
        if (i == nums.length) {
            return 0;
        }

        String key = i + "," + fresh;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        long take = 0, subtrac = 0,ans=Integer.MIN_VALUE;

        if (fresh == 0) {
            take = nums[i] + solve(i + 1, 0, nums, memo);
            subtrac = -nums[i] + solve(i + 1, 1, nums, memo);
            ans=Math.max(take,subtrac);
        } else {
            take = nums[i] +  solve(i + 1, 0, nums, memo);
            memo.put(key,take);
            ans=take;
            
        }
        memo.put(key,ans);
        return ans;
    }

}


class Solution4 {
    public long helper(int[]arr,int i,int prev,long[][]dp){
        if(i==arr.length)return 0;
        if(dp[i][prev]!=(long)(-1e9))return dp[i][prev];
        long not=arr[i]+helper(arr,i+1,1,dp);
        if(prev!=0){
            not=Math.max(not,(-1*arr[i])+helper(arr,i+1,0,dp));
        }
        // long take=arr[i]+(-1*prev)+helper(arr,i+1,1-prev,dp);
        return dp[i][prev]=not;
    }
    public long maximumTotalCost(int[] nums) {
        int n = nums.length;
        long [][]dp=new long[n][2];
        for(long []i:dp){
            Arrays.fill(i,(long)(-1e9));
        }
        return helper(nums,0,0,dp);
    }
}