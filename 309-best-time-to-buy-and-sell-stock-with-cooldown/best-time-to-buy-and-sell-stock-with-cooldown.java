class Solution2 {
    public int maxProfit(int[] prices) {
         Map<String, Integer> cache = new HashMap<>();
        return dfs(0, true, prices, cache);
    }

    private int dfs(int currIdx, boolean canBuy,int[] prices, Map<String, Integer> cache) {
        if (currIdx >= prices.length) {
            return 0;
        }

        StringBuilder keyBuilder = new StringBuilder();
        keyBuilder.append(currIdx).append("-").append(canBuy);
        String key = keyBuilder.toString();

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        // do nothing
        int nothing = dfs(currIdx + 1, canBuy,prices, cache);

        // buy
        int action;
        if (canBuy) {
            action = dfs(currIdx + 1, false, prices, cache) - prices[currIdx];
        }
        // sell
        else {
            action = dfs(currIdx + 2, true,prices, cache) + prices[currIdx];
        }

        int best = Math.max(nothing, action);
        cache.put(key, best);
        return best;
    }
}


class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return dfs(0, 1, prices, dp);
    }

    private int dfs(int currIdx, int canBuy, int[] prices, int[][] dp) {
        if (currIdx >= prices.length) {
            return 0;
        }
        
        if (dp[currIdx][canBuy] != -1) {
            return dp[currIdx][canBuy];
        }

        // do nothing
        int nothing = dfs(currIdx + 1, canBuy, prices, dp);

        // buy
        int action;
        if (canBuy == 1) {
            action = dfs(currIdx + 1, 0, prices, dp) - prices[currIdx];
        }
        // sell
        else {
            action = dfs(currIdx + 2, 1, prices, dp) + prices[currIdx];
        }

        int best = Math.max(nothing, action);
        dp[currIdx][canBuy] = best;
        return best;
    }
}
