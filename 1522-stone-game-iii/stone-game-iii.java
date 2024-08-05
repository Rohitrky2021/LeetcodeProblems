class Solution1 {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[3];

        for (int i = n - 1; i >= 0; i--) {
            int takeOne = stoneValue[i] - dp[(i + 1) % 3];
            int takeTwo = Integer.MIN_VALUE;
            if (i + 1 < n) {
                takeTwo = stoneValue[i] + stoneValue[i + 1] - dp[(i + 2) % 3];
            }
            int takeThree = Integer.MIN_VALUE;
            if (i + 2 < n) {
                takeThree = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[(i + 3) % 3];
            }

            dp[i % 3] = Math.max(takeOne, Math.max(takeTwo, takeThree));
        }

        int scoreDiff = dp[0];
        if (scoreDiff > 0) {
            return "Alice";
        } else if (scoreDiff < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}

class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        Integer[] memo = new Integer[n];
        int scoreDiff = stoneGameHelper(stoneValue, 0, memo);
        
        if (scoreDiff > 0) {
            return "Alice";
        } else if (scoreDiff < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    private int stoneGameHelper(int[] stoneValue, int i, Integer[] memo) {
        int n = stoneValue.length;
        if (i >= n) {
            return 0;
        }

        if (memo[i] != null) {
            return memo[i];
        }

        int takeOne = stoneValue[i] - stoneGameHelper(stoneValue, i + 1, memo);
        int takeTwo = Integer.MIN_VALUE;
        if (i + 1 < n) {
            takeTwo = stoneValue[i] + stoneValue[i + 1] - stoneGameHelper(stoneValue, i + 2, memo);
        }
        int takeThree = Integer.MIN_VALUE;
        if (i + 2 < n) {
            takeThree = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - stoneGameHelper(stoneValue, i + 3, memo);
        }

        memo[i] = Math.max(takeOne, Math.max(takeTwo, takeThree));
        return memo[i];
    }
}
