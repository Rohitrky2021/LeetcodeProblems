class Solution {
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
