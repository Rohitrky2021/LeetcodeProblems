// class Solution {
//     public int numberOfPaths(int[][] grid, int k) {
//         int sum=0;
//         int m = grid.length;
//         int n = grid[0].length;
//         int dp[][] = new int[m][n];
//         return helper(grid,0,0,m,n,dp,k,sum);
//     }

//     public int helper(int[][] grid,int r,int c,int m,int n,int[][] dp,int k,int sum){
//         //  sum=0;
//         if(r == m || c == n )return 0;
//         if(r == m-1 && c == n-1  ){
//             sum+=grid[r][c];
//             System.out.println(grid[r][c] +" "+sum);
//             if(sum%k==0)return 1;
//             return 0;
//         }
//         System.out.println(grid[r][c] +" "+sum);
//         sum+=grid[r][c];
//         if(dp[r][c] > 0)return dp[r][c];

//         return dp[r][c] = helper(grid,r+1,c,m,n,dp,k,sum)+helper(grid,r,c+1,m,n,dp,k,sum);
//     }
// }
class Solution {
    int[][][] dp;
    int mod = 1_000_000_007;
    
    public int numberOfPaths(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        dp = new int[rows][cols][k];
        
        return helper(grid, 0, 0, 0, k);
    }
    
    int helper(int[][] grid, int r, int c, int sum, int k) {
        if( r == grid.length || c == grid[0].length) {
            return 0;
        }
        
        sum += grid[r][c];
        if(r == grid.length-1 && c == grid[0].length-1) {// r==m-1 && c==n-1
            return sum%k==0 ? 1 : 0;
        }
        
        // For this Think iun 3D i.e -> for every r,c their will be List of sum%k values 
        if(dp[r][c][sum%k] >0) {
            return dp[r][c][sum%k];// i.r eske pehle ka Remainder i have handleded end result same hoga as Sum of + This Remainder 
        }
        
        dp[r][c][sum%k] = (helper(grid, r+1, c, sum, k) + helper(grid, r, c+1, sum, k)) % mod; // We dont have to store Path 
        // Store only the Mod%k ones 
        return dp[r][c][sum%k];
    }
}

// class Solution {
//     int mod = (int)1e9+7;
//     int dp[][][];
//     public int numberOfPaths(int[][] arr, int k) {
//         int r = arr.length;
//         int c = arr[0].length;
        
//         dp = new int[r][c][(int)1e2];
        
//         return solve(arr,k,0,0,arr.length,arr[0].length,0);
        
//     }
//     int solve(int[][]arr,int k,int i,int j,int r,int c,int sum){
//         if(i>=r || j>=c || i<0 || j<0)return 0;
//         if(i==r-1 && j==c-1){
            
//             if((sum+arr[i][j])%k==0)return 1;
//             else return 0;
//         }
//         if(dp[i][j][sum%k]!=0)return dp[i][j][sum%k];
        
//         int right = solve(arr,k,i,j+1,r,c,sum+arr[i][j])%mod;
//         int down = solve(arr,k,i+1,j,r,c,sum+arr[i][j])%mod;
        
//         return dp[i][j][sum%k]=(right+down)%mod;
//     }
// }