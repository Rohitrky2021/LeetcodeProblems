// class Solution {
//     public int atMostNGivenDigitSet(String[] digits, int n) {
        
//     }
// }

// import java.util.ArrayList;
// import java.util.List;

class Solution {
    private int[][][] dp;

    private int count(int idx, boolean tight, String num, boolean atleast1Dig, String[]  digits) {
        if (idx == num.length()) return 1;
        if (dp[idx][tight ? 1 : 0][atleast1Dig ? 1 : 0] != -1) return dp[idx][tight ? 1 : 0][atleast1Dig ? 1 : 0];
        int lo = 0;
        int hi = tight ? num.charAt(idx) - '0' : 9;
        int cnt = 0;
        if (!atleast1Dig) {
            cnt += count(idx + 1, false, num, false, digits);
        }
        for (String digit : digits) {
            int dig = digit.charAt(0) - '0';
            if (dig > hi) continue;
            cnt += count(idx + 1, tight && (dig == hi), num, true, digits);
        }
        return dp[idx][tight ? 1 : 0][atleast1Dig ? 1 : 0] = cnt;
    }

    public int atMostNGivenDigitSet(String[]  digits, int n) {
        dp = new int[10][2][2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < dp[0][0].length; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        String num = String.valueOf(n);
        return count(0, true, num, false, digits) - 1;
    }
 
}
