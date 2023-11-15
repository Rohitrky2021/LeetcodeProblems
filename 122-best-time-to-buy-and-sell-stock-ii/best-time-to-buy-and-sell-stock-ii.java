class Solution {

    public int maxProfit(int[] prices) {
         Map<String, Integer> cache = new HashMap<>();
        return dfs(0, prices, cache);
    }

    private int dfs(int currIdx, int[] prices, Map<String, Integer> cache) {
        if (currIdx >= prices.length - 1) {
            return 0;
        }

        String key = String.valueOf(currIdx);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        // buy on current day and sell on the next day
        int buySell = 0;
        for (int i = currIdx + 1; i < prices.length; i++) {
            if (prices[i] > prices[currIdx]) {
                int profit = prices[i] - prices[currIdx] + dfs(i + 1, prices, cache);
                buySell = Math.max(buySell, profit);
            }
        }

        // skip current day
        int skip = dfs(currIdx + 1, prices, cache);

        int maxProfit = Math.max(buySell, skip);
        cache.put(key, maxProfit);
        return maxProfit;
    }


}