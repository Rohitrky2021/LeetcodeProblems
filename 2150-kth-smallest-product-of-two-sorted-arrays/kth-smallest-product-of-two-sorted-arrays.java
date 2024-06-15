class Solution1 {
    public int findMaxNegativeIndex(int[] nums) {
        var low = 0;// negtive no
        var high = nums.length - 1;// not a negative no
        if (nums[low] > 0)
            return -1;// don't not have any negative value
        if (nums[high] < 0)
            return high;// all numbers are negative
        while (low < high) {
            var m = (low + high + 1) / 2;
            if (nums[m] < 0) {
                low = m;
            } else {
                if (high == m)
                    break;
                high = m;
            }
        }
        return low;
    }

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = Long.MIN_VALUE / 2;// have less than k no product than this
        long high = Long.MAX_VALUE / 2;// have atleast k no product less than this
        var negInd1 = findMaxNegativeIndex(nums1);
        var negInd2 = findMaxNegativeIndex(nums2);
        while (low < high) {
            long m = low + (high - low) / 2;
            var val = getNoOfProductLessThan(m, nums1, nums2, negInd1, negInd2);
            if (k <= val) {
                high = m;
            } else {
                if (low == m)
                    break;
                low = m;
            }
        }

        return high;
    }

    public long getNoOfProductLessThan(long m, int[] nums1, int[] nums2, int f, int s) {
        var l1 = nums1.length;
        var l2 = nums2.length;

        long ans = 0;

        // when nums1 pos and nums2 is pos
        var j = l2 - 1;
        for (int i = f + 1; i < l1; i++) {
            // special case when nums1[i] == 0
            if (nums1[i] == 0) {
                if (m >= 0)
                    ans += l2;
                continue;
            }
            while (j > s && ((long) nums1[i] * (long) nums2[j] > m)) {
                j--;
            }
            if (j > s)
                ans += j - s;
        }

        // when nums1 pos and nums2 is neg
        j = s;
        for (int i = l1 - 1; i > f; i--) {
            if (nums1[i] == 0)
                break;
            while (j >= 0 && ((long) nums1[i] * (long) nums2[j] > m)) {
                j--;
            }
            if (j >= 0)
                ans += (j + 1);
        }

        // when nums1 neg and nums2 is neg
        j = 0;
        for (int i = f; i >= 0; i--) {
            while (j <= s && ((long) nums1[i] * (long) nums2[j] > m)) {
                j++;
            }
            if (j <= s)
                ans += (s - j + 1);
        }

        // when nums1 neg and nums2 is pos
        j = s + 1;
        for (int i = 0; i <= f; i++) {
            while (j < l2 && ((long) nums1[i] * (long) nums2[j] > m)) {
                j++;
            }
            if (j < l2)
                ans += (l2 - j);
        }
        return ans;
    }
}

// -=============================>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>............................

class Solution2 {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long l = (long) -1e11;
        long r = (long) 1e11;
        long res = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            // checking whether we have k at least k elements whose product is less than the
            // current product
            // if yes then we know we have to move left
            if (check(mid, nums1, nums2, k)) {
                r = mid - 1;
                res = mid;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public boolean check(long mid, int[] nums1, int[] nums2, long k) {
        long cnt = 0;
        for (int i = 0; i < nums1.length; i++) {
            long val = (long) nums1[i];
            // if current element is 0 and we out current product is >= 0 then we can add
            // the whole second array because 0*anything will be 0
            if (val == 0 && mid >= 0) {
                cnt += nums2.length;
            } else if (val < 0) {
                // If we encounter negative value we find the minimum index in the second array
                // such that this element * minIndexElement <= current product
                cnt += findMinIndex(val, mid, nums2);
            } else if (val > 0) {
                // if we encounter positive element we find max index in the second array such
                // that this element * maxIndexElement <= current product
                cnt += findMaxIndex(val, mid, nums2);
            }
        }
        // if we have atleast k elements whose product is less than current product
        return cnt >= k;
    }

    public long findMaxIndex(long val, long mid, int[] nums2) {
        int l = 0;
        int r = nums2.length - 1;
        // when no element in second array when multiplied by the current element of the
        // first array yields result less that current product we will return res+1
        // hence -1 + 1 hence 0 coz there are no elements which when multiplied by
        // current element of the first array yield result less than current product.
        long res = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (val * nums2[m] <= mid) {
                // if our current product is >= val*current element then we move the window to
                // right side in order to find max index with which when multiplied the element
                // of the first array is still less than current product.
                res = (long) m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        // so we have found res+1 elements who satisfy our condition. +1 coz res would
        // give index
        return res + 1;
    }

    public long findMinIndex(long val, long mid, int[] nums2) {
        int l = 0;
        int r = nums2.length - 1;
        // when all elements of second array multiplied by current element of first
        // array yield result > current product then we return 0 coz there are no
        // elements which would yield us result.
        long res = r + 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (val * nums2[m] <= mid) {
                r = m - 1;
                res = (long) m;
            } else {
                l = m + 1;
            }
        }
        return nums2.length - res;
    }
}

// -=============================>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>............................

class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        // 1. define search space
        long left = (long) -1e11;
        long right = (long) 1e11;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countSmaller(nums1, nums2, mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // At the end, left is the product that has k smaller products before it, so the
        // kth smallest product is left - 1
        return left - 1;
    }

    private long countSmaller(int[] nums1, int[] nums2, long product) {
        long count = 0;
        for (int i = 0; i < nums1.length; i++) {
            // count all nums2[j] such that nums1[i] * nums2[j] < product
            if (nums1[i] >= 0) {
                int left = 0;
                int right = nums2.length;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    // if nums1[i] > 0, find the first occurrence of nums2[j] where nums1[i] *
                    // nums2[j] >= product
                    if ((long) nums1[i] * nums2[mid] < product) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                count += left;
            } else {
                int left = 0;
                int right = nums2.length;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    // since nums1[i] is negative, nums2 is sorted
                    // nums[j] * nums[i] will be in descending order from [0...nums2.length-1]
                    // take [-4,-2,0,3] as an example, product with a negative number will become
                    // smaller if the number gets bigger
                    // want to find the last nums2[j] such that nums1[i] * nums2[j] is not smaller
                    // than product
                    if ((long) nums1[i] * nums2[mid] >= product) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                count += nums2.length - left;
            }
        }
        return count;
    }
}
