class Solution {

    public int maxProfit(int[] prices, int fee) {
          Map<String, Integer> cache = new HashMap<>();
        return dfsWithTransactionFee(0, true, 0, prices, fee, cache);
    }

    private int dfsWithTransactionFee(int currIdx, boolean canBuy, int numTxns, int[] prices, int fee, Map<String, Integer> cache) {
        if (currIdx >= prices.length) {
            return 0;
        }

        String key = currIdx + "-" + canBuy ;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        // do nothing
        int nothing = dfsWithTransactionFee(currIdx + 1, canBuy, numTxns, prices, fee, cache);

        // buy
        int actionBuy;
        if (canBuy) {
            actionBuy = dfsWithTransactionFee(currIdx + 1, false, numTxns, prices, fee, cache) - prices[currIdx] - fee;
        } else {
 
        // sell
        actionBuy = dfsWithTransactionFee(currIdx + 1, true, numTxns + 1, prices, fee, cache) + prices[currIdx];
        }
        int best =Math.max(nothing, actionBuy);
        cache.put(key, best);
        return best;
    }

}
