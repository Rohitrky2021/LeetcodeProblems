class Solution {

    int MOD = 1000000007;
    int dp[][][]=new int[100001][2][3];


    public int checkRecord(int n) {
        return  solve(n,0,0);
    }

    public int solve(int n,int a,int l) {
        if(n==0)return 1;

        if(dp[n][a][l] != 0)
            return dp[n][a][l];

        int ans =0;

        // Taking 'A' absence
        if(a<1)
            ans=(ans+solve(n-1,a+1,0))%MOD;

        // Taking 'L' late
        if(l<2)
            ans=(ans+solve(n-1,a,l+1))%MOD;

        // Taking 'P' present
        ans=(ans+solve(n-1,a,0))%MOD;

        return dp[n][a][l] = ans;

    }
}
