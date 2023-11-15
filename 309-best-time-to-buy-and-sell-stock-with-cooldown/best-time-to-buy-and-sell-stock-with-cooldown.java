class Solution {
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