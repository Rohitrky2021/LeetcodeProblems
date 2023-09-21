class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            addNum(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            addNum(nums2[i]);
        }

        return findMedian();
    }

    public   void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }

    private   PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    private   PriorityQueue<Integer> large = new PriorityQueue<>();

    private   boolean even = true;

    public   double findMedian() {
        if (even) return (small.peek() + large.peek()) / 2.0; 
        else return small.peek();
    }
}
