import java.util.HashSet;

class Solution {
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
