import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int count = 0;
        
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int end = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (end > intervals[i][0]) {
                count++;
                end = Math.min(intervals[i][1], end);
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }
}
