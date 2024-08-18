 
class Solution {
    private static final int MOD = 1_000_000_007;

    public int countOfPairs(int[] nums) {
        int prefixZeros = 0;
        int n = nums.length;

        // Calculate prefix zeros
        for (int i = 1; i < n; i++) {
            prefixZeros += Math.max(nums[i] - nums[i - 1], 0);
        }

        int row = n + 1;
        int col = nums[n - 1] + 1 - prefixZeros;

        if (col <= 0) {
            return 0;
        }

        // Use a map for memoization
        Map<String, Integer> memo = new HashMap<>();

        // Recursively compute the result with memoization
        return countPairsHelper(row - 1, col - 1, memo);
    }

    private int countPairsHelper(int r, int c, Map<String, Integer> memo) {
        // Base case: If we're at the first row or first column
        if (r == 0 || c == 0) {
            return 1;
        }

        // Memoization key
        String key = r + "," + c;

        // If already computed, return the result
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Recurrence relation: dp[r][c] = dp[r-1][c] + dp[r][c-1]
        int result = (countPairsHelper(r - 1, c, memo) + countPairsHelper(r, c - 1, memo)) % MOD;

        // Store result in the memoization map
        memo.put(key, result);

        return result;
    }
}
