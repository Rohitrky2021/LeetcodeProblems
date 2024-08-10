class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;

        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < col - 2; j++) {
                // Check if numbers are distinct and in range 1-9
                if (!isValid(grid, i, j)) continue;

                // first row 
                int sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
                // rows 
                if (grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] != sum) continue;
                if (grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] != sum) continue;

                // columns 
                if (grid[i][j] + grid[i + 1][j] + grid[i + 2][j] != sum) continue;
                if (grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1] != sum) continue;
                if (grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] != sum) continue;

                // diagonals 
                if (grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] != sum) continue;
                if (grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] != sum) continue;

                count++;
            }
        }

        return count;
    }

    private boolean isValid(int[][] grid, int i, int j) {
        boolean[] seen = new boolean[10];
        for (int x = i; x <= i + 2; x++) {
            for (int y = j; y <= j + 2; y++) {
                int num = grid[x][y];
                if (num < 1 || num > 9 || seen[num]) return false;
                seen[num] = true;
            }
        }
        return true;
    }
}