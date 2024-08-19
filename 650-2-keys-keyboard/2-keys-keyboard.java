class Solution1 {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0; // 1 'A' requires 0 operations

        for (int i = 2; i <= n; i++) {
            dp[i] = i; // Start with the worst case: all single additions (i-1 pastes)
            for (int j = i / 2; j > 0; j--) {
                if (i % j == 0) {  // j is a divisor of i
                    dp[i] = dp[j] + (i / j);
                    break;
                }
            }
        }
        
        return dp[n];
    }
}
 

class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();
    
    public int minSteps(int n) {
        // Base case: If we already have 1 'A', no more steps are needed
        if (n == 1) return 0;

        // Check if the result is already computed
        if (memo.containsKey(n)) return memo.get(n);

        // Initialize the minimum steps to n (worst case)
        int minSteps = n;

        // Try all divisors of n
        for (int i = n / 2; i >= 1; i--) {
            if (n % i == 0) {  // i is a divisor of n
                // Recursively solve the subproblem and update the minimum steps
                minSteps = Math.min(minSteps, minSteps(i) + (n / i));
                break;
            }
        }

        // Memoize the result
        memo.put(n, minSteps);
        return minSteps;
    }
}
