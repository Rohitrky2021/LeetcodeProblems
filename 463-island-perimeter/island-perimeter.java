class Solution {
    public static int islandPerimeter(int[][] grid) {
        int V = grid.length;
    int ans=0;
         

        boolean[][] visited = new boolean[V][grid[0].length];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j <grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                  return dfs(grid, i, j, visited);
                }
            }
        }
        return ans;
    }

   
    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length ) {
            return 1; // If we are out of bounds or at water, add to the perimeter
        }
       if (grid[row][col] == 0) {
            return 1;
        }
         
        if (visited[row][col]) {
            return 0; // If we have already visited, no need to add to the perimeter
        }
        visited[row][col] = true;
        int perimeter = 0;

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            perimeter += dfs(grid, newRow, newCol, visited);
        }

        return perimeter;
    }
}

public class Solution2 {
   public int islandPerimeter(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        int up, down, left, right;
        int result = 0;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    if (r == 0) { up = 0; }
                    else { up = grid[r-1][c]; }
                     
                    if (c == 0) { left = 0; } 
                    else { left = grid[r][c-1]; }
                        
                    if (r == rows-1) { down = 0; }
                    else { down = grid[r+1][c]; }
                        
                    if (c == cols-1) { right = 0; }
                    else { right = grid[r][c+1]; }
                        
                    result += 4-(up+left+right+down);
                }
            }
        }

        return result;
    }
}



class Solution3 {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int result = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    result += 4;
                    
                    if (r > 0 && grid[r-1][c] == 1) {
                        result -= 2;
                    }
                    
                    if (c > 0 && grid[r][c-1] == 1) {
                        result -= 2;
                    }
                }
            }
        }
        
        return result;
    }
}