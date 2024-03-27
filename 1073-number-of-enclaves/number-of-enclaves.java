class Solution2 {

    // Trick -->Reverse Thinking All 4 Boundries k 1 ko Check dfs Krke Jitne Connected Honge Unko Zero Krdenge
    // those 1's who are left are not connected to any Boundary
    public int numEnclaves(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) { // Iterate over all columns as well
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
                    dfs(grid, i, j);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) { // Iterate over all columns as well
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    // public void dfs(int[][] grid, int i, int j) {
    //     if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
    //         return;
    //     }

    //     for (int[] dir : direc) {
    //         int newRow = i + dir[0];
    //         int newCol = j + dir[1];
    //     grid[i][j] = 0;
    //         dfs(grid, newRow, newCol);
    //     }
    // }

    public void dfs(int[][] grid, int i, int j) {
          if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
            grid[i][j] = 0;
        for (int m = 0; m < 4; m++) {
            dfs(grid, i + direc[m][0], j + direc[m][1]);
        }
    }

    // public void dfs(int[][] grid, int i, int j) {
    //     if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
    //         return;
    //     }
    //     grid[i][j] = 0;
    //     dfs(grid, i - 1, j);
    //     dfs(grid, i + 1, j);
    //     dfs(grid, i, j - 1);
    //     dfs(grid, i, j + 1);
    // }

    static int[][] direc = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
}


class Solution1 {

    // Trick -->Reverse Thinking All 4 Boundries k 1 ko Check dfs Krke Jitne Connected Honge Unko Zero Krdenge
    // those 1's who are left are not connected to any Boundary
   public int numEnclaves(int[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) { // Iterate over all columns as well
            if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
                dfs(grid, i, j);
            }
        }
    }
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) { // Iterate over all columns as well
            if (grid[i][j] == 1) {
                count++;
            }
        }
    }
    return count;
}

    public void dfs(int[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j]==0) {
                return;
            }
    grid[i][j]=0;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);

    }

    static int[][] direc = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
}


 

class Pair {
    int row;
    int col;
    
    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Solution {
    public static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        Queue<Pair> q = new LinkedList<>();
        // Marking boundary land cells as visited
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if((i == 0 || j == 0 || i == n - 1 || j == m - 1) && grid[i][j] == 1){
                    q.add(new Pair(i, j));
                    vis[i][j] = 1;
                }
            }
        }

        int[] delRow = {0, -1, 0, 1};
        int[] delCol = {-1, 0, 1, 0};
        
        // BFS to mark connected land cells
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();

            for(int i = 0; i < 4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
        
        // Counting unvisited land cells
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    
    
}


