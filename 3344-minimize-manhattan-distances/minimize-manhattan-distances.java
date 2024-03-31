import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int minimumDistance(int[][] points) {
        int n = points.length; // Number of points
        int minMaxDist = Integer.MAX_VALUE; // Initialize the minimum maximum distance
        
        // Two ArrayLists to store the sums of x and y coordinates for each point
        ArrayList<int[]> v1 = new ArrayList<>();
        ArrayList<int[]> v2 = new ArrayList<>();
        
        // Calculate the sum of x+y and x-y for each point and store them in the ArrayLists
        for (int i = 0; i < n; i++) {
            v1.add(new int[]{points[i][0] + points[i][1], i});
            v2.add(new int[]{points[i][0] - points[i][1], i});
        }
        
        // Sort the ArrayLists based on the calculated sums
        Collections.sort(v1, (a, b) -> a[0] - b[0]);
        Collections.sort(v2, (a, b) -> a[0] - b[0]);

        // Iterate through each point
        for (int i = 0; i < n; i++) {
            // Calculate the maximum sum of x+y after removing the current point
            int[] v1Max = v1.get(n - 1)[1] == i ? v1.get(n - 2) : v1.get(n - 1);
            // Calculate the maximum sum of x-y after removing the current point
            int[] v2Max = v2.get(n - 1)[1] == i ? v2.get(n - 2) : v2.get(n - 1);
            // Calculate the minimum sum of x+y after removing the current point
            int[] v1Min = v1.get(0)[1] == i ? v1.get(1) : v1.get(0);
            // Calculate the minimum sum of x-y after removing the current point
            int[] v2Min = v2.get(0)[1] == i ? v2.get(1) : v2.get(0);
            
            // Calculate the maximum of the differences between maximum and minimum sums
            int maxDist = Math.max(v1Max[0] - v1Min[0], v2Max[0] - v2Min[0]);
            // Update the minimum maximum distance
            minMaxDist = Math.min(minMaxDist, maxDist);
        }
        
        return minMaxDist; // Return the minimum maximum distance
    }
}
