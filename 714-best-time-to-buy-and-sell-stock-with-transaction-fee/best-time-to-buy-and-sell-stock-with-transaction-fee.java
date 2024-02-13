class Solution2 {

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
 

class Solution {

    public int maxProfit(int[] prices, int fee) {
        Map<String, Integer> cache = new HashMap<>();
        return dfsWithTransactionFee(0, true, 0, prices, fee, cache);
    }

    private int dfsWithTransactionFee(int currIdx, boolean canBuy, int numTxns, int[] prices, int fee, Map<String, Integer> cache) {
        if (currIdx >= prices.length) {
            return 0;
        }

        String key = currIdx + "-"+ canBuy;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int profit = 0;

        if (canBuy) {
            // Either we skip this buy, or we buy
            int skipBuy = dfsWithTransactionFee(currIdx + 1, true, numTxns, prices, fee, cache);
            int buy = dfsWithTransactionFee(currIdx + 1, false, numTxns, prices, fee, cache) - prices[currIdx] - fee;
            profit = Math.max(skipBuy, buy);
        } else {
            // Either we skip this sell, or we sell
            int skipSell = dfsWithTransactionFee(currIdx + 1, false, numTxns + 1, prices, fee, cache);
            int sell = dfsWithTransactionFee(currIdx + 1, true, numTxns, prices, fee, cache) + prices[currIdx];
            profit = Math.max(skipSell, sell);
        }

        cache.put(key, profit);
        return profit;
    }
}




class Solution3 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        Integer[][] cache = new Integer[n][2];
        return dfsWithTransactionFee(0, true, 0, prices, fee, cache);
    }

    private int dfsWithTransactionFee(int currIdx, boolean canBuy, int numTxns, int[] prices, int fee, Integer[][] cache) {
        if (currIdx >= prices.length) {
            return 0;
        }

        if (cache[currIdx][canBuy ? 1 : 0] != null) {
            return cache[currIdx][canBuy ? 1 : 0];
        }

        // do nothing
        int nothing = dfsWithTransactionFee(currIdx + 1, canBuy, numTxns, prices, fee, cache);

        // buy or sell
        int actionBuySell;
        if (canBuy) {
            actionBuySell = dfsWithTransactionFee(currIdx + 1, false, numTxns, prices, fee, cache) - prices[currIdx] - fee;
        } else {
            actionBuySell = dfsWithTransactionFee(currIdx + 1, true, numTxns + 1, prices, fee, cache) + prices[currIdx];
        }

        int best = Math.max(nothing, actionBuySell);
        cache[currIdx][canBuy ? 1 : 0] = best;
        return best;
    }
}
