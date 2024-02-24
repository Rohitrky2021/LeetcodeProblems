class Solution1 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }
    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            // this lower part can be written in a better manner 
            if (r >= 1) dfs(image, r-1, c, color, newColor);
            if (c >= 1) dfs(image, r, c-1, color, newColor);
            if (r+1 < image.length) dfs(image, r+1, c, color, newColor);
            if (c+1 < image[0].length) dfs(image, r, c+1, color, newColor);
        }else{
            return ;
        }
    }
}


class Solution{
    public static void dfs(int row, int col, int[][] ans, int[][] image, int newColor, int iniColor){
        int n = image.length;
        int m = image[0].length;
        ans[row][col] = newColor;
        for(int i = 0; i < 4; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == iniColor && ans[nrow][ncol] != newColor){
                dfs(nrow, ncol, ans, image, newColor,iniColor);
            }
        }
    }
    static int[] delRow = {-1, 0, 1, 0};
    static int[] delCol = {0, 1, 0, -1};
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];
        int[][] ans = image;
        dfs(sr, sc, ans, image, color,iniColor);
        return ans;
    }

}