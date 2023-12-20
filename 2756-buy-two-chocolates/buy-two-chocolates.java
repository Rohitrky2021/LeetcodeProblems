class Solution {

    public int buyChoco(int[] prices, int money) {
        // int arr[]=new []''
        int m = 0;
        int ans = 0, count = 0;
        Arrays.sort(prices);
        int k = money;
        for (int p : prices) {
            // if( k-ans>=0){
            count++;
            ans += p;
            // }
            if (ans <= k && count == 2) {
                return m = k - ans;
            } else if (ans >= k) {
                return m = k;
            }
        }

        return m;
    }
}
