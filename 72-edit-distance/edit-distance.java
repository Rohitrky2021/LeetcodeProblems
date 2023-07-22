class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length() + 1][word2.length() + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return check(word1, word2, word1.length(), word2.length(), memo);
    }

    public int check(String w1, String w2, int m, int n, int[][] memo) {
        if (m == 0) {
            return n;
        }

        if (n == 0) {
            return m;
        }

        if (memo[m][n] != -1) {
            return memo[m][n];
        }

        if (w1.charAt(m - 1) == w2.charAt(n - 1)) {
            memo[m][n] = check(w1, w2, m - 1, n - 1, memo);
        } else {
            int ans1 = check(w1, w2, m, n - 1, memo);
            int ans2 = check(w1, w2, m - 1, n, memo);
            int ans3 = check(w1, w2, m - 1, n - 1, memo);
            memo[m][n] = Math.min(ans1, Math.min(ans2, ans3)) + 1;
        }

        return memo[m][n];
    }
}
