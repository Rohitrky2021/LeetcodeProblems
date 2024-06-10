class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        if (n < 2) return 0;

        int[] pre = new int[n];
        int[] suff = new int[n];
        
        pre[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pre[i] = arr[i] ^ pre[i - 1];
        }
        
        suff[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] ^ arr[i];
        }
        
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j; k < n; k++) {
                    int a = pre[j - 1] ^ (i > 0 ? pre[i - 1] : 0);
                    int b = suff[j] ^ (k + 1 < n ? suff[k + 1] : 0);
                    if (a == b) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}
