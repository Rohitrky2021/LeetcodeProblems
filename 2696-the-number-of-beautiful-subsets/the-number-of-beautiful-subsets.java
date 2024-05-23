class Solution1 {
    public int dfs(int[] nums, int idx, int k, HashMap<Integer, Integer> mp) {
        if (idx == nums.length) return 1;

        int taken = 0;
        if (!mp.containsKey(nums[idx] - k) && !mp.containsKey(nums[idx] + k)) {
            mp.put(nums[idx], mp.getOrDefault(nums[idx], 0) + 1);
            taken = dfs(nums, idx + 1, k, mp);
            mp.put(nums[idx], mp.get(nums[idx]) - 1);
            if (mp.get(nums[idx]) == 0) {
                mp.remove(nums[idx]);
            }
        }
        
        int notTaken = dfs(nums, idx + 1, k, mp);
        
        return taken + notTaken;
    }

    public int beautifulSubsets(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans = dfs(nums, 0, k, mp);
        return ans - 1;
    }
}

class Solution {
  private int dfs(int[] nums, int k, int i, Set<Integer> set) {
    if (i == nums.length)
     return set.isEmpty() ? 0 : 1;

    var cnt = dfs(nums, k, i+1, set);
    
    if (set.contains(nums[i] - k)) return cnt;

    set.add(nums[i]);
    cnt += dfs(nums, k, i+1 ,set);
    set.remove(nums[i]);

    return cnt;
  }

  public int beautifulSubsets(int[] nums, int k) {
    Arrays.sort(nums);

    return dfs(nums, k, 0, new HashSet<Integer>());
  }
}