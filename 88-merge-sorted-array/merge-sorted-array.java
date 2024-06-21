class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = nums1.length - 1;
        int p2 = n - 1, p1 = m - 1;
        while (p2 > -1 && p1 > -1) {
            if (nums1[p1] > nums2[p2])
                nums1[k--] = nums1[p1--];
            else
                nums1[k--] = nums2[p2--];
        }

        // when n1[0]-->is empty -->no one to compare with the N2
        while (p2 > -1)
            nums1[k--] = nums2[p2--];
    }
}