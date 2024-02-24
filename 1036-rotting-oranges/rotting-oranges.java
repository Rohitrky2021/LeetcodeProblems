// This is the Shortest Distance type and we know for that BFS is the best method to Solve 
class Solution1 {
    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0, freshcnt = 0, mt = 0;
        Queue<Pair> q = new LinkedList<>();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 2) {
                    q.add(new Pair(row, col, 0));
                    vis[row][col] = 2;
                }
                if (grid[row][col] == 1)
                    freshcnt++;
            }
        }
        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            int r = q.peek().first;
            int c = q.peek().second;
            int t = q.peek().time;
            mt = Math.max(mt, t);
            q.remove();
            for (int i = 0; i < 4; i++) {
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    vis[nrow][ncol] = 2;
                    q.add(new Pair(nrow, ncol, t + 1));
                    cnt++;
                }
            }
        }
        if (cnt != freshcnt)
            return -1;
        return mt;
    }
 static class Pair {
    int first;
    int second;
    int time;

    Pair(int first, int second, int time) {
        this.first = first;
        this.second = second;
        this.time = time;
    }
}   
}

// But a DFS method Solution is there TRICKY WAY 

class Solution {
    
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) rotAdjacent(grid, i, j, 2);
            }
        }
        
        int minutes = 2;
        for(int[] row : grid) {
            for(int cell : row) {
                if(cell == 1) return -1;
                minutes = Math.max(minutes, cell);
            }
        }
        
        return minutes - 2;
    }
    
    private void rotAdjacent(int[][] grid, int i, int j, int minutes) {
        if(i < 0 || i >= grid.length /* out of bounds */
          || j < 0 || j >= grid[0].length /* out of bounds */
          || grid[i][j] == 0 /* empty cell */
          || (1 < grid[i][j] && grid[i][j] < minutes) /* this orange is already rotten by another rotten orange */
          ) return;
        else {
            grid[i][j] = minutes;
            rotAdjacent(grid, i - 1, j, minutes + 1);
            rotAdjacent(grid, i + 1, j, minutes + 1);
            rotAdjacent(grid, i, j - 1, minutes + 1);
            rotAdjacent(grid, i, j + 1, minutes + 1);
        }
    }
}