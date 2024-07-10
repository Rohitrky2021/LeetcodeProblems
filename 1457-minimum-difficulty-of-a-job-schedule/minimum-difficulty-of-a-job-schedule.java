import java.util.Arrays;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String, Integer> map = new HashMap<>();

    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }
        return dfs(0, jobDifficulty, d, -1);
    }

    int dfs(int i, int[] jb, int d, int max) {
        String key = i + " " + d + " " + max;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (d == 0 && i == jb.length) {
            return 0;
        }
        if (d == 0 || i == jb.length) {
            return 10000;
        }
        int ans=10000;

        max = Math.max(max, jb[i]);
        
        // take in my current day 
        int take = dfs(i + 1, jb, d, max);

        // ignore
        int ignore= max + dfs(i + 1, jb, d - 1, -1);

        ans = Math.min(ans,Math.min(ignore,take)); //abtuk ka max or   new day ka call bhej do 

        map.put(key, ans);
        return ans;
    }
}


class Solution3 {
    public int minDifficulty(int[] jobDifficulty, int d) {
        return help(jobDifficulty, d, 0, new Integer[jobDifficulty.length][d + 1]);
    }

    public int help(int[] arr, int k, int idx, Integer[][] memo) {
        if (k == 1) {
            int max = Integer.MIN_VALUE;
            for (int i = idx; i < arr.length; i++) {
                max = Math.max(max, arr[i]);
            }
            return max;
        }

        if (memo[idx][k] != null)
            return memo[idx][k];

        int max = Integer.MIN_VALUE;
        int minDifficulty = Integer.MAX_VALUE;

        for (int i = idx; i <= arr.length - k; i++) {
            max = Math.max(max, arr[i]);
            int nextDifficulty =  max + help(arr, k - 1, i + 1, memo); // mENd my this day & going to the another day 
            if (nextDifficulty != -1)
                minDifficulty = Math.min(minDifficulty,nextDifficulty);
        }

        memo[idx][k] = (minDifficulty == Integer.MAX_VALUE) ? -1 : minDifficulty;
        return memo[idx][k];
    }
}


class Solution1 {  // Recurrsion only soluiton so will give TLE 
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }
        int len = jobDifficulty.length;
        int sum = 0;
        for (int i = 0; i < jobDifficulty.length; i++) {
            sum += jobDifficulty[i];
        }
        if (sum == 0) {
            return 0;
        }
        return helper(jobDifficulty, d, 0);
    }

    private int helper(int[] jd, int daysLeft, int idx) {
        int len = jd.length;
        if (daysLeft == 1) {
            int num = 0;
            for (int i = idx; i < len; i++) {
                num = Math.max(num, jd[i]);
            }
            return num;
        }

        int max = jd[idx];
        daysLeft--;
        int stop = len - idx - daysLeft + 1;

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < stop; i++) {
            max = Math.max(max, jd[idx + i - 1]);
            int ans = max +  helper(jd, daysLeft, idx + i); // , idx + i --> starting ccheck for new day from idx in new looop
            res = Math.min(res, ans);
        }
        return res;
    }
}

class Solution2 {
    public int minDifficulty(int[] jobDiff, int d) {
        if(d > jobDiff.length) return -1;
        int res = diff(0, jobDiff, d);
        if(res == Integer.MAX_VALUE) return -1;
        return res;
    }
    private int diff(int curr, int jobDiff[], int d) {
        if(curr >= jobDiff.length && d <= 0) return 0;
        if(curr >= jobDiff.length || d <= 0) return Integer.MAX_VALUE;
        int maxDiff = -1;
        int res = Integer.MAX_VALUE;
        for(int i = curr; i<jobDiff.length; i++) {  // es loop k liye andar waali saari cheeze valid rhenge 
            maxDiff = Math.max(maxDiff, jobDiff[i]);
            int temp =  diff(i+1, jobDiff, d-1);
            if(temp != Integer.MAX_VALUE) res = Math.min(res,maxDiff + temp);
        }
        return res;
    }
}