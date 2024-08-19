class Solution2 {
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

        // Initialize dp array
        int[] dp = new int[col];
        for (int i = 0; i < col; i++) {
            dp[i] = 1;
        }

        // Fill dp array
        for (int r = 1; r < row; r++) {
            for (int c = 1; c < col; c++) {
                dp[c] = (dp[c] + dp[c - 1]) % MOD;
            }
        }

        return dp[col - 1];
    }
}
 
class Solution1 { // TLE AS not opitmised 
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

 

class Solution3 {
    private static final int MOD = 1_000_000_007;

    public int countOfPairs(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][1001];

        // Initialize the dp array for the first element
        for (int j = 0; j <= nums[0]; j++) {
            dp[0][j] = 1;
        }

        // Fill the dp array for the remaining elements
        for (int i = 1; i < n; i++) {
            int ways = 0;
            int k = 0;
            for (int j = 0; j <= nums[i]; j++) {
               // problem I
                // for (int j = 0; j <= nums[i]; j++){
                //     int ways = 0;
                //     for (int k = 0; k <= 50; k++){
                //         if (k <= j && nums[i - 1] - k >= nums[i] - j)
                //             ways = (ways + dp[i - 1][k]) % MOD;
                //     }
                //     dp[i][j] = ways;
                // }
                // problem II
                if (k <= Math.min(j, j - (nums[i] - nums[i - 1]))) {
                    ways = (ways + dp[i - 1][k]) % MOD;
                    k++;
                }
                dp[i][j] = ways;
            }
        }

        // Calculate the result
        int res = 0;
        for (int i = 0; i <= 1000; i++) {
            res = (res + dp[n - 1][i]) % MOD;
        }

        return res;
    }
}

 
class Solution {
    private static final int MOD = 1_000_000_007;

    public int countOfPairs(int[] nums) {
        int n = nums.length;
        int mn = nums[0];
        int num1 = 0, num2 = mn;

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num < num1) {
                return 0;
            }

            if (num > num1 + num2) {
                num1 = num - num2;
            }

            num2 = num - num1;

            if (num2 < mn) {
                mn = num2;
            }
        }

        return combination(n + mn, mn) % MOD;
    }

    private int combination(int n, int k) {
        // Calculate C(n, k) % MOD using dynamic programming
        int[] comb = new int[k + 1];
        comb[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, k); j > 0; j--) {
                comb[j] = (comb[j] + comb[j - 1]) % MOD;
            }
        }

        return comb[k];
    }
}
