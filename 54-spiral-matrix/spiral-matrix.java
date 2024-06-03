class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans=new ArrayList<>();
        int row=0 , rowls=matrix.length-1;
        int col=0 , colls=matrix[0].length-1;
        while(row<=rowls && col<=colls){
            for(int i=col; i<=colls; i++){
                ans.add(matrix[row][i]);
            }
            row++;
            for(int i=row; i<=rowls; i++){
                ans.add(matrix[i][colls]);
            }
            colls--;
            if(rowls>=row){
                for(int i=colls; i>=col; i--){
                    ans.add(matrix[rowls][i]);
                }
                
            }
            rowls--;
            if(col<=colls){
                for(int i=rowls; i>=row; i--){
                    ans.add(matrix[i][col]);

                }
                
            }
            col++;
        }
        return ans;
    }
}


class Solution2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = cols-1, top = 0, bottom = rows-1;
        
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return result;
    }
}