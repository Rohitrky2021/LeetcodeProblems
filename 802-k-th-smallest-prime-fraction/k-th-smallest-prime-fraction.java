import java.util.*;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        if (n == 2) return new int[]{arr[0], arr[1]};

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> (double) a[0] / a[1]));

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pq.offer(new int[]{arr[i], arr[j]});
            }
        }

        while (--k > 0) {
            pq.poll();
        }

        return pq.poll();
    }
}
