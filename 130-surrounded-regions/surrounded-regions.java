class Solution1 {
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
                if(board[i][j]=='1')board[i][j]='O';

            }
        }
        
    }

    public void dfs(int row, int col, char[][] grid) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 'O') {
            grid[row][col] = '1';  // JO kaam krna h reach krne k baaad 
            dfs(row, col + 1, grid);
            dfs(row, col - 1, grid);
            dfs(row + 1, col, grid);
            dfs(row - 1, col, grid);
        }
    }
}

class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;

        // Mark boundary and connected 'O's as '1'
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                dfs(board, i, cols - 1);
            }
        }

        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[rows - 1][j] == 'O') {
                dfs(board, rows - 1, j);
            }
        }

        // Mark the remaining 'O's as 'X', and revert '1's back to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O') {
            return;
        }

        board[row][col] = '1';

        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}
