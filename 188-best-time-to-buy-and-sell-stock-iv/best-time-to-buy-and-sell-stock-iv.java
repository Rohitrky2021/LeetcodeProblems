class Solution {
    public int maxProfit(int k, int[] prices) {
      Map<String, Integer> cache = new HashMap<>();
        return dfs(0, true, 0, k, prices, cache);
    }

    private int dfs(int currIdx, boolean canBuy, int numTxns, int k, int[] prices, Map<String, Integer> cache) {
        if (numTxns >= k || currIdx == prices.length) {
            return 0;
        }

        String key = currIdx + "-" + canBuy + "-" + numTxns;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        // do nothing
        int nothing = dfs(currIdx + 1, canBuy, numTxns, k, prices, cache);

        // buy
        int action;
        if (canBuy) {
            action = dfs(currIdx + 1, false, numTxns, k, prices, cache) - prices[currIdx];
        }
        // sell
        else {
            action = dfs(currIdx + 1, true, numTxns + 1, k, prices, cache) + prices[currIdx];
        }

        int best = Math.max(nothing, action);
        cache.put(key, best);
        return best;
    }
}