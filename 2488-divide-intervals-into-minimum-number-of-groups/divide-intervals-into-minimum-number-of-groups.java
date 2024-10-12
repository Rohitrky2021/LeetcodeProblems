import java.util.*;

class Solution {
    public int minGroups(int[][] intervals) {
        // Sort the intervals based on their start time. If start times are the same, sort by end time.
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        // Priority queue (min-heap) to keep track of group end times
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Iterate through all intervals
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            // If the earliest ending group is before the current interval starts, remove it
            if (!pq.isEmpty() && pq.peek() < start) {
                pq.poll();
            }

            // Add the current interval's end time to the priority queue (this represents a new group or updating an existing one)
            pq.add(end);
        }

        // The size of the priority queue gives the minimum number of groups
        return pq.size();
    }
}
