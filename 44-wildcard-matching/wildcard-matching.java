class Solution {
    public boolean isMatch(String s, String p) {
        return tabu(  s,  p, s.length(), p.length());
    }

        public static boolean tabu(String s, String p, int n, int m){
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true; // 1
        for(int i = 1; i<=n; i++){ // 2
            dp[i][0] = false;
        }
        for(int j = 1; j<=m; j++){ // 3
            if(p.charAt(j-1) != '*'){
                break;
            }
            dp[0][j] = true;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] | dp[i-1][j] | dp[i-1][j-1];
                }
                else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
}