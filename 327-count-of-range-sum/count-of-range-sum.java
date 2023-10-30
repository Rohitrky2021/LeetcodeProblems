class Solution {

    public int countRangeSum(int[] nums, int lower, int upper) {
        // Calculate the prefix sums of the input array
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; ++i) sums[i + 1] = sums[i] + nums[i];

        // Call the recursive function to count the range sums
        return countRangeSumRecursive(sums, 0, n + 1, lower, upper);
    }

    private int countRangeSumRecursive(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) {
            return 0;
        }

        int mid = (start + end) / 2;

        // Recursively count range sums in the left and right subarrays
        int count = countRangeSumRecursive(sums, start, mid, lower, upper) + countRangeSumRecursive(sums, mid, end, lower, upper);

        int j = mid, k = mid, t = mid;
        long[] cache = new long[end - start];

        for (int i = start, r = 0; i < mid; ++i, ++r) {
            while (k < end && sums[k] - sums[i] < lower) k++;
            while (j < end && sums[j] - sums[i] <= upper) j++;
            while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++];

            cache[r] = sums[i];
            count += j - k;
        }

        // Copy the merged array back into the original sums array
        System.arraycopy(cache, 0, sums, start, t - start);

        return count;
    }
}
