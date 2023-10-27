class Solution {
    public double findMaxAverage(int[] arr, int k) {
     
        int n = arr.length;

        // int k = 3;
        int sum = 0;
        double msum=Integer.MIN_VALUE;

        // Calculate the sum of the first k elements
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        msum=sum;

        // Calculate the sum of all subarrays of size k
        for (int i = k; i < n; i++) {
           sum = sum + arr[i] - arr[i - k];
           msum= Math.max(msum,sum);

        }
        return (double) msum/k;

        
    }
} 