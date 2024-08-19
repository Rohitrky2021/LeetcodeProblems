/**
 * @param {number} n
 * @return {number}
 */
var minSteps = function(n) {
            let dp = new Array(n + 1).fill(0);
        dp[1] = 0; // 1 'A' requires 0 operations

        for (let i = 2; i <= n; i++) {
            dp[i] = i; // Start with the worst case: all single additions (i-1 pastes)
            for (let j = Math.floor(i / 2); j > 0; j--) {
                if (i % j === 0) {  // j is a divisor of i
                    dp[i] = dp[j] + (i / j);
                    break;
                }
            }
        }
        
        return dp[n];

};