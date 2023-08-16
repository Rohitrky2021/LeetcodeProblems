class Solution {

// SIMPLER BUT THE THING IS THAT ITS NOT LIKE PREVIOUS WHERE------TC-O(N+M) && SC O(K);
//     TC-O(N*LOGN*K)   --->AS SORTING ALWAYS FOR K  && SC O(K)

//    public class MaxSlidingWindowPQ {
//     // public class PQSamekthlargelemet {
//     public static void main(String[] args) {
//         int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//         int k = 3;

//         int[] result = maxSlidingWindow(nums, k);

//         for (int num : result) {
//             System.out.print(num + " ");
//         }
//     }

// THis gives below TLE

    // public static int[] maxSlidingWindow(int[] nums, int k) {
    //     if (nums == null || nums.length == 0 || k <= 0) {
    //         return new int[0];
    //     }

    //     int n = nums.length;
    //     int[] result = new int[n - k + 1];
    //     int ri = 0; // result index

    //     // Create a max heap (PriorityQueue with reverse ordering)
    //     PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

    //     // Process the first 'k' elements to populate the initial sliding window
    //     for (int i = 0; i < k; i++) {
    //         pq.offer(nums[i]);
    //     }

    //     // Add the maximum element for the first window to the result array
    //     result[ri++] = pq.peek();

    //     // Process the rest of the elements
    //     for (int i = k; i < n; i++) {
    //         // Remove the leftmost element from the window
    //         pq.remove(nums[i - k]);
    //         // Add the current element to the window
    //         pq.offer(nums[i]);
    //         // Add the maximum element for the current window to the result array
    //         result[ri++] = pq.peek();
    //     }

    //     return result;
    // }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        Deque<Integer> deque = new ArrayDeque<>();

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0; // result index

            for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        
        for (int i = k; i < n; i++) {
            // Add the maximum element (kth largest) for the current window to the result array
            result[ri++] = nums[deque.peekFirst()];

            // Remove elements that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove elements that are smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add the current element's index to the deque
            deque.offerLast(i);
        }
        result[ri] = nums[deque.peekFirst()];

        return result;
    }
}

// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7




// [1,3,-1,-3,5,3,6,7]