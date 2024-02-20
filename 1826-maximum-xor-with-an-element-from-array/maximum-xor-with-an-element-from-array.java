class Solution1 {
    // M1 --> Brute Force
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        Arrays.sort(nums); // Sort the nums array
        for (int i = 0; i < n; i++) {
            int xi = queries[i][0];
            int mi = queries[i][1];
            int maxXor = -1; // Initialize maxXor to -1
            for (int num : nums) {
                if (num > mi)
                    break; // If num exceeds mi, break the loop
                int currentXor = xi ^ num; // Compute the XOR value
                if (currentXor > maxXor) { // Update maxXor if currentXor is greater
                    maxXor = currentXor;
                }
            }
            result[i] = maxXor; // Store the maxXor for the current query
        }
        return result;
    }
}

// M2 --> USing BInary Search
/*
 * Time Complexity : O((N + M) * log(N))
 * Space Complexity : O(1)
 * 
 * Where N is the length of the input string.
 */

public class Solution {

    static int lowerBound(int[] ar, int l, int h, int k) {
        int low = l;
        int high = h;
        int mid = 0;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (k <= ar[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if (low < h && ar[low] < k) {
            low++;
        }
        return low;
    }

    static int upperBound(int[] ar, int l, int h, int k) {
        int low = l;
        int high = h;
        int mid = 0;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (k >= ar[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (low < h && ar[low] <= k) {
            low++;
        }
        return low;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int[] result = new int[m];

        // Sort nums array in non-decreasing order.
        Arrays.sort(nums);

        // Finding answer for each query.
        for (int i = 0; i < m; i++) {
            int xi = queries[i][0];
            int mi = queries[i][1];

            // If answer to this query is -1.
           if (mi < nums[0]) {
                result[i] = -1;
                continue;
            }
            int left = 0;
            int right = upperBound(nums, 0, n, mi);
            int ans = 0;
            int cur = 0;

            for (int j = 30; j >= 0; j--) {
                // If jth bit is set in xi
                if ((xi & (1 << j)) > 0) {
                    if ((nums[left] & (1 << j)) <= 0) {
                        ans |= (1 << j);
                        right = lowerBound(nums, left, right, cur + (1 << j));
                    } else {
                        cur |= (1 << j);
                    }
                } else {
                    // If jth bit is not set in xi
                    if ((nums[right - 1] & (1 << j)) > 0) {
                        ans |= (1 << j);
                        cur |= (1 << j);
                        left = lowerBound(nums, left, right, cur);
                    }
                }
            }

            result[i] =  ans;
        }

        return result;
    }
}
