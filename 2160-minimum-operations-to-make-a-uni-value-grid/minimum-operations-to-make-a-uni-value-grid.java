import java.util.*;

class Solution1 {
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


class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int size = m * n;
        int[] arr = new int[size];

        // Flatten the 2D grid into a 1D array
        int index = 0;
        for (int[] row : grid) {
            for (int num : row) {
                arr[index++] = num;
            }
        }

        // Sort the array to find the median efficiently
        Arrays.sort(arr);

        // Compute GCD of all elements relative to the smallest one
        int base = arr[0];
        int gcd = 0;
        for (int num : arr) {
            gcd = computeGCD(gcd, num - base);
        }

        // If x cannot divide the GCD, return -1 (impossible case)
        if (gcd % x != 0) return -1;

        // Find the median (middle element in sorted array)
        int median = arr[size / 2];

        // Calculate the minimum number of operations
        int operations = 0;
        for (int num : arr) {
            operations += Math.abs(num - median) / x;
        }

        return operations;
    }

    // Optimized GCD function (Iterative to avoid recursion overhead)
    private int computeGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
