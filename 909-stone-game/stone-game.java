class Solution1 {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Integer[][] memo = new Integer[n][n];
        return stoneGameHelper(piles, 0, n - 1, memo) > 0;
    }

    private int stoneGameHelper(int[] piles, int left, int right, Integer[][] memo) {
        if (left > right) {
            return 0;
        }

        if (memo[left][right] != null) {
            return memo[left][right];
        }

        // Player's choice is either take the left or the right pile
        int takeLeft = piles[left] - stoneGameHelper(piles, left + 1, right, memo);
        int takeRight = piles[right] - stoneGameHelper(piles, left, right - 1, memo);

        memo[left][right] = Math.max(takeLeft, takeRight);
        return memo[left][right];
    }
}


class Solution {
    public boolean stoneGame(int[] piles) {
    return true;    
    }
}