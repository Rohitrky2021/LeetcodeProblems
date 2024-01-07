 public class Solution{
        public int minimumTotal(List<List<Integer>> triangle) {
        for (int row = 1; row < triangle.size(); row++) {
            for (int col = 0; col <= row; col++) {
                 int smallestAbove = Integer.MAX_VALUE;           
                if (col > 0) {
                    smallestAbove = triangle.get(row - 1).get(col - 1);
                } 
                if (col < row) {
                    smallestAbove = Math.min(smallestAbove, triangle.get(row - 1).get(col));
                }
                int path = smallestAbove + triangle.get(row).get(col);
                triangle.get(row).set(col, path);
            }
        }
        return Collections.min(triangle.get(triangle.size() - 1));
    }
}


 class Solution3 {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = triangle.size() - 2; i >= 0; i--)
            for(int j = 0; j <= i; j++)
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
        return triangle.get(0).get(0);
    }
}


// // Top-Down Memoization:
// private Integer[][] memo;

// public int minimumTotal(List<List<Integer>> triangle) {
// 	int n = triangle.size();
// 	memo = new Integer[n][n];
// 	return dfs(0, 0, triangle);
// }

// private int dfs(int level, int i, List<List<Integer>> triangle) {
// 	if (memo[level][i] != null) return memo[level][i];

// 	int path = triangle.get(level).get(i);
// 	if (level < triangle.size() - 1) 
// 		path += Math.min(dfs(level + 1, i, triangle), dfs(level + 1, i + 1, triangle));

// 	return memo[level][i] = path;
// }

// // Bottom-Up DP:
// public int minimumTotal4(List<List<Integer>> triangle) {
// 	int n = triangle.size();
// 	int[][] dp = new int[n+1][n+1];

// 	for (int level=n-1; level>=0; level--)
// 		for (int i=0; i<=level; i++)
// 			dp[level][i] = triangle.get(level).get(i) + Math.min(dp[level+1][i], dp[level+1][i+1]);

// 	return dp[0][0];
// }

class Solution5 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // create dp table
        int[][] memo = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for (int[] row: memo)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        // start from the top of the triangle
        return recurse(triangle, 0, 0, memo);
    }
    
    private int recurse(List<List<Integer>> triangle, int row, int col, int[][] memo) {
        // base case
        if (row == triangle.size())
            return 0;
        
        // check dp table
        if (memo[row][col] != Integer.MAX_VALUE)
            return memo[row][col];
        
        // either go to [row + 1, col] or [row + 1, col + 1]
        int remain = Math.min(recurse(triangle, row + 1, col, memo),
                              recurse(triangle, row + 1, col + 1, memo));
        
        // combine answer with current value
        memo[row][col] = triangle.get(row).get(col) + remain;
        return memo[row][col];
    }
}