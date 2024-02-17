
class Solution1 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;
        
        int m = board.length;
        int n = board[0].length;
        
        // Iterate through each cell in the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0))
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        // If the entire word has been matched, return true
        if (index == word.length())
            return true;
        
        int m = board.length;
        int n = board[0].length;
        
        // Check if the current cell is out of bounds or the character doesn't match
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(index))
            return false;
        
        // Temporarily mark the current cell as visited
        char temp = board[i][j];
        board[i][j] = '#';
        
        // Check adjacent cells recursively
        boolean found = dfs(board, i - 1, j, word, index + 1) ||
                        dfs(board, i + 1, j, word, index + 1) ||
                        dfs(board, i, j - 1, word, index + 1) ||
                        dfs(board, i, j + 1, word, index + 1);
        
        // Restore the original value of the current cell
        board[i][j] = temp;
        
        return found;
    }
}


public class Solution {
    static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }
        
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }
        
        visited[i][j] = true;
        if(search(board, word, i-1, j, index+1) || 
           search(board, word, i+1, j, index+1) ||
           search(board, word, i, j-1, index+1) || 
           search(board, word, i, j+1, index+1)){
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }
}