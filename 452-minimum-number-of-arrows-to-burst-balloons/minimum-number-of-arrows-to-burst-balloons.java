import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0)
            return 0;

        // Sorting by end points
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1; // Initialize arrows count to 1
        int end = points[0][1]; // End point of the first balloon

        // Loop through remaining balloons
        for (int i = 1; i < points.length; i++) {
            // If the current balloon starts after the end point, it needs a new arrow
            if (points[i][0] > end) {
                arrows++; // Increment arrows count
                end = points[i][1]; // Update end point
            }
        }

        return arrows;
    }
}
