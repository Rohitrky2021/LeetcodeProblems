import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> values = new ArrayList<>();
        
        // Flatten the grid and find the GCD of differences
        for (int[] row : grid) {
            for (int num : row) {
                values.add(num);
            }
        }

        // Sort the list
        Collections.sort(values);

        // Find the GCD of all elements relative to the smallest one
        int base = values.get(0);
        int gcd = 0;
        for (int num : values) {
            gcd = gcd(gcd, num - base);
        }

        // If x does not divide GCD, return -1
        if (gcd % x != 0) return -1;

        // Find median as the optimal value
        int median = values.get(values.size() / 2);
        
        // Compute the total operations
        int operations = 0;
        for (int num : values) {
            operations += Math.abs(num - median) / x;
        }
        
        return operations;
    }

    // Helper function to calculate GCD
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
