class Solution {
    private int count = 0;

    public int reversePairs(int[] nums) {
        count = 0;
        if (nums.length == 0) return 0;
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    private int[] mergeSort(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return new int[]{nums[lo]};
        }

        int mid = lo + (hi - lo) / 2;
        int[] left = mergeSort(nums, lo, mid);
        int[] right = mergeSort(nums, mid + 1, hi);

        return mergeAndCount(left, right);
    }

    private int[] mergeAndCount(int[] left, int[] right) {   // Now play with Function think u ahve a function & 2 sorted arrays
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        for (i = 0, j = 0; i < left.length; i++) {
            while (j < right.length && left[i] > 2L * right[j]) {
                j++;
            }
            count += j;
        }

        i = 0;
        j = 0;
        k = 0;

        // Merge the two sorted arrays
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
            }
        }

        while (i < left.length) {
            merged[k++] = left[i++];
        }

        while (j < right.length) {
            merged[k++] = right[j++];
        }

        return merged;
    }
}
