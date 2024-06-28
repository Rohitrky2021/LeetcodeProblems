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
        } else {
            take = nums[i] +  solve(i + 1, 0, nums, memo);
            memo.put(key,take);
            return take;
        }
        ans=Math.max(take,subtrac);
        memo.put(key,ans);
        return ans;
    }

}