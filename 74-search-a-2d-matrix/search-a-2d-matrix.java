class Solution {
    // public boolean searchMatrix(int[][] m, int t) {
    //     int i=m.length-1,j=0;
    //     // j=m[0].length;
    //     int curr=m[i][j];


    //    while(i<)
    // }

    // public boolean searchMatrix(int[][] m, int t) {
    //     int i=0,j=m[0].length-1;

    //     while(i<m.length && j>=0){
    //         if(m[i][j]==t){
    //             return true;
    //         }
    //         if(m[i][j]<t){
    //             i++;
    //         }
    //         else if(m[i][j]>t){
    //             j--;
    //         }
    //     }
    //     return false;

    // }
    
   /**
 *  Do binary search in this "ordered" matrix
 */
public boolean searchMatrix(int[][] matrix, int target) {
	
	int row_num = matrix.length;
	int col_num = matrix[0].length;
	
	int begin = 0, end = row_num * col_num - 1;
	if (matrix.length == 0 || matrix[0].length == 0) return false;
	while(begin <= end){
		int mid = begin + (end-begin) / 2;
		int mid_value = matrix[mid/col_num][mid%col_num];
		
		if( mid_value == target){
			return true;
		
		}else if(mid_value < target){
			//Should move a bit further, otherwise dead loop.
			begin = mid+1;
		}else{
			end = mid-1;
		}
	}
	
	return false;
}
       
}