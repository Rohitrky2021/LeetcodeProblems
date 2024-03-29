
// DFS code this will give TLE
class Solution1 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // If the start or end cell is blocked, return -1
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1)
            return -1;

        // Perform DFS
        int len = dfs(0, 0, grid);

        // If destination cell is unreachable, return -1
        if (len == Integer.MAX_VALUE)
            return -1;

        return len;
    }

    public int dfs(int i, int j, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Check if current cell is out of bounds or blocked
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 1)
            return Integer.MAX_VALUE;

        // Check if we have reached the destination cell
        if (i == n - 1 && j == m - 1)
            return 1;

        // Mark the current cell as visited
        grid[i][j] = 1;

        // Explore adjacent cells
        int minLen = Integer.MAX_VALUE;
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            int len = dfs(x, y, grid);
            if (len != Integer.MAX_VALUE)
                minLen = Math.min(minLen, len + 1);
        }

        // Reset the current cell to unvisited
        grid[i][j] = 0;

        return minLen;
    }
}


// BFS code This is Accepeted one not give TLE 
class Node{
    int r,c;
    public Node(int r, int c){
        this.r = r;
        this.c = c;
    }
}
class Solution {
	// 8 - direction array
    int[] x = {1,-1,0,0, 1,-1,1,-1}; // cols
    int[] y = {0,0,1,-1, 1,1,-1,-1}; // rows
    public int shortestPathBinaryMatrix(int[][] grid) {
       int n = grid.length; 
       if(grid==null || n==0 || grid[0][0]!=0  || grid[n-1][n-1]!=0) // if start is not 0 or destination is not 0, return -1
           return -1;
       if(n==1) // if grid consists of just one cell
           return 1;
		   
        // bottom to up
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n-1, n-1));
        grid[n-1][n-1] = 1;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int k=0;k<8;k++){
                int i = node.r + y[k];
                int j = node.c + x[k];
                if(i<0 || i>=n || j<0 || j>=n || grid[i][j]!=0) // if next cell is not zero skip it i.e visited
                    continue;
				// since we are modifying existing matrix, we dont't need extra data structure to keep track of visited cell
                grid[i][j] = grid[node.r][node.c]+1; // cost of reaching destination from (i,j)
                if(i==0 && j==0)
                    return grid[i][j];
                queue.add(new Node(i, j)); // add it to the queue
            }
        }
        return -1;
    }
}