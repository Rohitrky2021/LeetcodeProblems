//   M 1 --> Brute force 
public class Solution1 {
    public int findMaxForm(String[] strs, int m, int n) {
        int maxlen = 0;
        for (int i = 0; i < (1 << strs.length); i++) {
            int zeroes = 0, ones = 0, len = 0;
            for (int j = 0; j < strs.length; j++) {
                if ((i & (1 << j)) != 0) {
                    int[] count = countzeroesones(strs[j]);
                    zeroes += count[0];
                    ones += count[1];
                    len++;
                }
            }
            if (zeroes <= m && ones <= n)
                maxlen = Math.max(maxlen, len);
        }
        return maxlen;

    }

    public int[] countzeroesones(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - '0']++;
        }
        return c;
    }
}


// M 2 Optimised Brute force

  class Solution2 {
    public int findMaxForm(String[] strs, int m, int n) {
        int maxlen = 0;
        for (int i = 0; i < (1 << strs.length); i++) {
            int zeroes = 0, ones = 0, len = 0;
            for (int j = 0; j < 32; j++) {
                if ((i & (1 << j)) != 0) {
                    int[] count = countzeroesones(strs[j]);
                    zeroes += count[0];
                    ones += count[1];
                    if (zeroes > m || ones > n)
                        break;
                    len++;
                }
            }
            if (zeroes <= m && ones <= n)
                maxlen = Math.max(maxlen, len);
        }
        return maxlen;
    }

    public int[] countzeroesones(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - '0']++;
        }
        return c;
    }
}


// M 3--> Rewcurrssive 
  class Solution3 {
    public int findMaxForm(String[] strs, int m, int n) {
        return calculate(strs, 0, m, n);
    }

    public int calculate(String[] strs, int i, int zeroes, int ones) {
        if (i == strs.length)
            return 0;
        int[] count = countzeroesones(strs[i]);
        int taken = -1;
        if (zeroes - count[0] >= 0 && ones - count[1] >= 0)
            taken = calculate(strs, i + 1, zeroes - count[0], ones - count[1]) + 1;
        int not_taken = calculate(strs, i + 1, zeroes, ones);
        return Math.max(taken, not_taken);
    }

    public int[] countzeroesones(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - '0']++;
        }
        return c;
    }
}


// Mwemo + DP 

  class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[m + 1][n + 1][strs.length + 1];
        return calcFindMaxForm(strs, m, n, 0, dp);
    }
    
    private int calcFindMaxForm(String[] strs, int m, int n, int i /** Used to get the ith string */, int[][][] dp) {
		if (i > strs.length - 1)
			return 0;

		if (m < 0 || n < 0)
			return 0;

		if (m == 0 && n == 0)
			return 0;

		if (dp[m][n][i] != 0)
			return dp[m][n][i];

		int zerosCount = calcCount(strs[i], '0');
		int onesCount = strs[i].length() - zerosCount;

		if (zerosCount <= m && onesCount <= n)
			return dp[m][n][i] = Math.max(1 + calcFindMaxForm(strs, m - zerosCount, n - onesCount, i + 1, dp),
					calcFindMaxForm(strs, m, n, i + 1, dp));
		else
			return dp[m][n][i] = calcFindMaxForm(strs, m, n, i + 1, dp);
	}

	private int calcCount(String str, char ch) {
		int count = 0;
		for (char tempCh : str.toCharArray()) {
			if (tempCh == ch)
				count++;
		}
		return count;
	}
}