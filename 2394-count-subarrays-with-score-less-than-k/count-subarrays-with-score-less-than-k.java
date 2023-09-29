class Solution {

    public long countSubarrays(int[] arr, long k) {
        if (k <= 1) return 0;
        int tail = 0;
        long sum = 0; // Change sum to long
        long ans = 0; // Change ans to long
        long len=0;
        for (int head = 0; head < arr.length; head++) {
            
            sum += arr[head];

            while (sum * (head - tail + 1) >= k && tail < arr.length) {
                // Remove the division operation
                sum -= arr[tail];

                tail++;
            }
            len = (head - tail + 1);
            if (sum < k) ans += len;
        }

        return ans;
    }
}
