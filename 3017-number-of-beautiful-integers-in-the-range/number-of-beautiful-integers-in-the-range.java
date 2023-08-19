import java.util.ArrayList;
import java.util.List;

class Solution {
    int k;
    int[][][][][][] dp = new int[11][11][2][25][11][2];

    int find(int len, boolean tight, int sum, int odd, boolean isZero, int actualLength, List<Integer> digits) {
        if (len == digits.size()) {
            if ((actualLength - odd == odd) && (sum == 0) && !isZero) {
                return 1;
            }
            return 0;
        }
        if (dp[len][actualLength][tight ? 1 : 0][sum][odd][isZero ? 1 : 0] != -1) {
            return dp[len][actualLength][tight ? 1 : 0][sum][odd][isZero ? 1 : 0];
        }

        int limit = 9, res = 0;
        if (tight) {
            limit = digits.get(len);
        }

        for (int dig = 0; dig <= limit; dig++) {
            res += find(len + 1, (tight && (dig == limit)), (10 * sum + dig) % k, odd + (dig % 2), (isZero && (dig == 0)), (isZero && (dig == 0)) ? 0 : actualLength + 1, digits);
        }

        return (dp[len][actualLength][tight ? 1 : 0][sum][odd][isZero ? 1 : 0] = res);
    }

    int go(int x) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 25; l++) {
                        for (int m = 0; m < 11; m++) {
                            for (int n = 0; n < 2; n++) {
                                dp[i][j][k][l][m][n] = -1;
                            }
                        }
                    }
                }
            }
        }
        
        List<Integer> digits = new ArrayList<>();
        int m = x;
        while (m > 0) {
            digits.add(m % 10);
            m /= 10;
        }
        Collections.reverse(digits);
        return find(0, true, 0, 0, true, 0, digits);
    }

    int numberOfBeautifulIntegers(int low, int high, int K) {
        k = K;
        return go(high) - go(low - 1);
    }
}