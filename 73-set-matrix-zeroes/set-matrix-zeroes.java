import java.util.HashSet;

// M1 using Set 
class Solution1 {
    public void setZeroes(int[][] mat) {
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int x : row) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[x][j] = 0;
            }
        }

        for (int y : col) {
            for (int x = 0; x < mat.length; x++) {
                mat[x][y] = 0;
            }
        }
    }
}


class Solution {

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRow = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    if (i == 0) {
                        firstRow = true;
                    } else {
                        matrix[i][0] = 0;
                    }
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }

        if (firstRow) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
