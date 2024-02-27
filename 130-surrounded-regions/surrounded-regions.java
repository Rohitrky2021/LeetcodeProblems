class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(board[i][j]=='O')dfs( i, j,board);
                }
            }
        }

        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O')board[i][j]='X';

            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='m')board[i][j]='O';

            }
        }
        
    }

    public void dfs(int row, int col, char[][] grid) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 'O') {
            grid[row][col] = 'm';  // JO kaam krna h reach krne k baaad 
            dfs(row, col + 1, grid);
            dfs(row, col - 1, grid);
            dfs(row + 1, col, grid);
            dfs(row - 1, col, grid);
        }
    }
}