class Solution1 {
    public long maximumTotalDamage(int[] nums) {
        Arrays.sort(nums);
        List<Pair<Integer, Long>> dp = new ArrayList<>();
        long preMax = 0, ans = 0;
        int dpIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            while (dpIdx < dp.size() && dp.get(dpIdx).getKey() + 2 < nums[i]) {
                preMax = Math.max(preMax, dp.get(dpIdx).getValue());
                dpIdx++;
            }

            int j = i;
            long cur = 0;
            while (j < nums.length && nums[j] == nums[i]) {
                cur += nums[j];
                j++;
            }

            ans = Math.max(ans, cur + preMax);
            dp.add(new Pair<>(nums[i], cur + preMax));
            i = j - 1;
        }
        return ans;
    }
}

// ------------------------------------------------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

class Solution2 {
    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        TreeMap<Long, Long> seen = new TreeMap<>();
        long res = 0L;
        for (int i = 0; i < power.length; i++) {
            long x = power[i], sum = 0L;
            while (i < power.length && power[i] == x) {
                sum += power[i];
                i++;
            }
            i--;
            Long tmp = seen.lowerKey(x - 2);
            if (tmp == null) {
                tmp = sum;
            } else {
                tmp = seen.get(tmp) + sum;
            }
            res = Math.max(res, tmp);
            seen.put(x, res);
            seen.put(x + 1, res);
            seen.put(x + 2, res);
        }
        return res;
    }
}

// ------------------------------------------------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


class Solution {
    public long maximumTotalDamage(int[] power) {
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int p : power) {
            count.merge(p, 1, Integer::sum);
        }

        Map<Integer, Long> cache = new HashMap<>();

        return solve(count.firstKey(), count, cache);
    }

    private long solve(Integer power, TreeMap<Integer, Integer> count, Map<Integer, Long> cache) {
        if (null == power) {
            return 0;
        }

        if (cache.containsKey(power)) {
            return cache.get(power);
        }

        // pick the current power
        long pick = (long) power * count.get(power) +   solve(count.ceilingKey(power + 3), count, cache);         // at least power + 3


        // unpick the current power
        long unpick = solve(count.ceilingKey(power + 1), count, cache);  // at least power + 1

        long best = Math.max(pick, unpick);
        cache.put(power, best);

        return best;
    }
}

// ------------------------------------------------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>



class Solution4 {

    private long helper(long[][] nums,int n,int i,long[] dp){
        if(i==n)return 0;
        if(dp[i]!=-1)return dp[i];
        long take = 0;
        int temp = i+1;
        if(temp<n && nums[temp][0]<=(nums[i][0]+2))temp++;
        if(temp<n && nums[temp][0]<=(nums[i][0]+2))temp++;               
        take = nums[i][0]*nums[i][1] + helper(nums,n,temp,dp);
        long not_take =  helper(nums,n,i+1,dp);
        return dp[i] = (take>not_take?take:not_take);
    }

    public long maximumTotalDamage(int[] power) {
        ArrayList<long[]> temp = new ArrayList<>();
        int pre = -1;
        Arrays.sort(power);
        int idx = 0;
        for(int i=0;i<power.length;i++){
            if(power[i]==pre){
                temp.get(idx-1)[1] += 1;
            }else{
                temp.add(new long[]{power[i],1});
                idx++;
            }
            pre = power[i];
        }
        
        
        int n = temp.size();
        long[][] nums = new long[n][2];
        HashMap<Long,Long> hash = new HashMap<>();
        long max = (long)0;
        for(int i=0;i<n;i++){
            nums[i] = temp.get(i);
            hash.put(nums[i][0],nums[i][0]*nums[i][1]);
        }
        long[] dp = new long[n];
        Arrays.fill(dp,(long)-1);
        return helper(nums,n,0,dp);
    }
}

// ------------------------------------------------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>



class Solution5 {
    public long maximumTotalDamage(int[] p) {
        int n = p.length;
        Arrays.sort(p);
        TreeMap<Integer, Integer> hm = new TreeMap<>();
        TreeMap<Integer, Integer> st = new TreeMap<>();
        HashMap<Integer, Integer> ind = new HashMap<>();
        int idx = -1;
        for(int i = 0; i < n; i++){
            hm.put(p[i], hm.getOrDefault(p[i], 0) + 1);
            if(!ind.containsKey(p[i])){
                idx++;
                ind.put(p[i],idx);
            }
        }
        for(int i = 0; i < n; i++){
            if(hm.containsKey(p[i]+1) && hm.containsKey(p[i] + 2)){
                st.put(ind.get(p[i]),2);
            }else if(hm.containsKey(p[i]+1) || hm.containsKey(p[i] + 2)){
                st.put(ind.get(p[i]),1);
            }
        }
        long s[] = new long[hm.size()];
        int it = 0;
        for(int key : hm.keySet()){
            s[it++] = (long)key*(long)(hm.get(key));
        }
        long dp[] = new long[s.length];
        Arrays.fill(dp, (long)(-1));
        return helper(s, 0, st, s.length, dp);
    }
    public long helper(long[] s, int index, TreeMap<Integer, Integer> hm, int n, long[] dp){
        if(index >= n){
            return (long)0;
        }
        if(dp[index] != (long)(-1)){
            return dp[index];
        }
        //long sum = 0;
        long take = s[index] + helper(s, index + hm.getOrDefault(index,0)+1, hm, n, dp);
        long notake =  helper(s, index + 1, hm, n, dp);
        return dp[index] = Math.max(take, notake);
    }
    //[1,6,6,1,1,5,4,3,7,7]
    //18, cr - 21
}

// ------------------------------------------------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>



class Solution6 {
    Map<Integer, Integer> map = new HashMap<>();
    public long maximumTotalDamage(int[] power) {
        int n = power.length;
        //store frequency of each el
        for(int el :power) {
            map.put(el, map.getOrDefault(el, 0)+1);
        } 
        //sort arr, so that we don't have to look for el-1, el-2 (will take elements in increasing order)
        Arrays.sort(power);
        //intialise dp
        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);
        return find(power, n, 0, dp);
    }
    public long find(int[] power, int n , int idx, long[] dp) {
        if(idx >= n) return 0;
        if(dp[idx+1] != -1) return dp[idx+1];
        //skip
        long skip = find(power, n, idx+1, dp);
        //find next index using bSearch
        int nextIdx = bSearch(power, idx+1, n-1, power[idx]+3);
        //for repeated elements we must take all occurences in order to get max sum, therefor el*(frequency)
        long take = (power[idx]*(long)map.get(power[idx])) + find(power, n, nextIdx, dp);
        
        return dp[idx+1] = Math.max(take, skip);
    }
    //binary search to find next takeable index
    public int bSearch(int[] arr, int s, int e, int val) {
        int ans = arr.length;
        while(s <= e) {
            int m = s+(e-s)/2;
            if(arr[m] >= val) {
                e = m-1;
                ans = m;
            }else s = m+1;
        }
        return ans;
    }
}

// ------------------------------------------------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


class Solution7 {
    public long maximumTotalDamage(int[] power) {
        
        Arrays.sort(power);
        int n = power.length;
        long dp[][] = new long[n][2];
        dp[0][0] = power[0];
        dp[0][1] = 0;
        long ans = power[0];
        
        for(int i=1;i<n;i++){
            if(power[i] == power[i-1]){
                dp[i][0] = power[i] + dp[i-1][0];
                dp[i][1] = dp[i-1][1];
                ans = Math.max(ans,Math.max(dp[i][1],dp[i][0]));
                continue;
            }
            int offset = 1;
            dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1]);
            while(i-offset >= 0 && power[i] - power[i-offset] <= 2){
                // dp[i][1] = Math.max(dp[i][1],Math.max(dp[i-offset][0],dp[i-offset][1]));
                offset++;
            }
            if(i-offset >= 0){
                dp[i][0] = Math.max(dp[i-offset][1],dp[i-offset][0]) + power[i];
            }
            dp[i][0] = Math.max(dp[i][0],power[i]);
            ans = Math.max(ans,Math.max(dp[i][0],dp[i][1]));
        }
        
        return ans;
        
    }
}

// ------------------------------------------------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


class Solution8 {
    public int fun(int x) {
        return x;
    }

    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> damage_freq = new HashMap<>();
        for (int dmg : power) {
            int key = fun(dmg);
            damage_freq.put(key, damage_freq.getOrDefault(key, 0) + 1);
        }

        List<Integer> unique_damage = new ArrayList<>(damage_freq.keySet());
        Collections.sort(unique_damage);

        int n = unique_damage.size();
        long[] dp = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            long current_damage = (long) unique_damage.get(i - 1) * damage_freq.get(unique_damage.get(i - 1));
            long take = current_damage;

            for (int j = i - 2; j >= 0; j--) {
                if (unique_damage.get(i - 1) - unique_damage.get(j) > 2) {
                    take += dp[j + 1];
                    break;
                }
            }

            long dont_take = dp[i - 1];
            dp[i] = Math.max(take, dont_take);
        }

        return dp[n];
    }
}

// ------------------------------------------------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


public class Solution9 {
    HashMap<Integer, Long> freq = new HashMap<>();

    public long getAns(List<Integer> pows, int n, int ind, long[] dp) {
        if (ind >= n) {
            return 0;
        }
        if (dp[ind] != -1) {
            return dp[ind];
        }

        long take = 0, notTake = 0, val = 0, val1 = 0, val2 = 0, val3 = 0, val4 = 0;
        take = (long) (freq.get(pows.get(ind)) * pows.get(ind));
        if (ind + 1 < n && pows.get(ind + 1) - pows.get(ind) > 2) {
            val1 = getAns(pows, n, ind + 1, dp);
        }
        if (ind + 2 < n && pows.get(ind + 2) - pows.get(ind) > 2) {
            val2 = getAns(pows, n, ind + 2, dp);
        }
        val3 = getAns(pows, n, ind + 3, dp);
        val4 = getAns(pows, n, ind + 1, dp);

        val = take + Math.max(val1, Math.max(val2, val3));
        dp[ind] = Math.max(val, val4);
        return dp[ind];
    }

    public long maximumTotalDamage(int[] power) {
        List<Integer> powerList = new ArrayList<>();
        for (int num : power) {
            powerList.add(num);

            freq.put(num, freq.getOrDefault(num, 0L) + 1);
        }
        HashSet<Integer> st = new HashSet<>(powerList);
        List<Integer> temp = new ArrayList<>(st);
        Collections.sort(temp);
        int n = temp.size();
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        return getAns(temp, n, 0, dp);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] power = {3, 1, 3, 7, 5, 7}; // Example input as int[]
        long result = solution.maximumTotalDamage(power);
        System.out.println(result); // Output: 54 (Example usage)
    }
}


// ------------------------------------------------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


class Solution10 {
    HashMap<Long,Long> dp[];
    HashMap<Integer,Integer> count;
    public long helper(ArrayList<Integer> arr,long prev,int i) {
        if(i==arr.size()) {
            return 0;
        }
        if(!dp[i].containsKey(prev)) {
        int curr = arr.get(i);
        long max = -1;
        if((curr-prev)>2) {
            long g = ((long)count.get(curr)*curr);
            if((i+1)<arr.size() && ((arr.get(i+1)-curr)>2)) {
           max = Math.max(g+helper(arr,curr,i+1),max); 
        } else {
            max = Math.max(g+helper(arr,curr,i+1),max);
            max = Math.max(helper(arr,prev,i+1),max);
        }
        } else {
            max = Math.max(helper(arr,prev,i+1),max);
        }
        dp[i].put(prev,max);
        }
        return dp[i].get(prev);
    }
    public long maximumTotalDamage(int[] power) {
        dp = new HashMap[power.length];
        count = new HashMap<>();
        for(int i=0; i<power.length; i++) {
            dp[i] = new HashMap<>();
        }
        Arrays.sort(power);
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<power.length; i++) {
            if(!count.containsKey(power[i])) {
                count.put(power[i],1);
                arr.add(power[i]);
            } else {
               count.put(power[i],count.get(power[i])+1); 
            }
        }
        long max = -1;
        for(int i=0; i<arr.size(); i++) {
            max = Math.max(helper(arr,-4,i),max);
        }
        return max;
    }
}