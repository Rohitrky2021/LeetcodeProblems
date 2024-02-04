// Catalan Number 
class Solution {
    public int numTrees(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return catalanMemo(n, memo);
    }

    public int catalanMemo(int n, int[] memo) {
        if (n <= 1)
            return 1;

        if (memo[n] != -1)
            return memo[n];

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += catalanMemo(i, memo) * catalanMemo(n - i - 1, memo);
        }
        memo[n] = res;
        return res;
    }
}

class Solution2 {
    public int numTrees(int n) {
        return catalanTABULAT(n);
    }

        public static int catalanTABULAT(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j < i; j++) {
                int left=dp[j];
                int right=dp[i-j-1];//Ci = Cj * Ci-j-1;
                dp[i]+=left*right;
            }
        }
        return dp[n];
    }
}