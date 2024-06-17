class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        
        TreeMap<Integer, Integer> hm = new TreeMap<>();
        for (int p : nums) {
            hm.merge(p, 1, Integer::sum);
        }

        return helper(nums, n, hm.firstKey() , hm);
    }
  TreeMap<Integer, Integer> dp = new TreeMap<>();


    public int helper(int[] nums, int n, Integer i, TreeMap<Integer, Integer> hm) {
        if (i == null) {
            return 0;
        }

        if(dp.containsKey(i)){
            return dp.get(i);
        }

        int take = i * hm.get(i) + helper(nums, n,   hm.ceilingKey(i+2), hm);
        int leave = helper(nums, n, hm.ceilingKey(i+1), hm);
        int ans = Math.max(take, leave);
        dp.put(i, ans);
        return ans;
    }

}