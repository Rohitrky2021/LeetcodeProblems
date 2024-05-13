// class Solution {
//     public int matrixScore(int[][] grid) {
        
//     }
// }


class Solution {
    public int matrixScore(int[][] grid) {

        // give a function code to calculate the number of 0 & 1s in an column or row
        // matrix
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        
        flipColumnIfMoreOnes(grid);
        // print the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        return convertToDecimal(grid);

    }

    public static int binaryToDecimal(int[] binaryRow) {
        int decimal = 0;
        int n = binaryRow.length;
        for (int i = 0; i < n; i++) {
            decimal += binaryRow[i] * Math.pow(2, n - i - 1);
        }
        return decimal;
    }

    public static int convertToDecimal(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int ans=0;

        for (int i = 0; i < rows; i++) {
            int decimalValue = binaryToDecimal(grid[i]);
            System.out.println("Row " + (i + 1) + " in decimal: " + decimalValue);
            ans+=decimalValue;
        }

        return ans;
    }

    public static void flipColumnIfMoreOnes(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int j = 1; j < cols; j++) {
            int ones = 0;
            int zeros = 0;

            // Count the number of ones and zeros in the current column
            for (int i = 0; i < rows; i++) {
                if (grid[i][j] == 0) {
                    zeros++;
                } else if (grid[i][j] == 1) {
                    ones++;
                }
            }

            // If there are more ones than zeros, flip the bits of the column
            if (ones < zeros) {
                for (int i = 0; i < rows; i++) {
                    grid[i][j] = (grid[i][j] == 0) ? 1 : 0;
                }
            }
        }
    }
}