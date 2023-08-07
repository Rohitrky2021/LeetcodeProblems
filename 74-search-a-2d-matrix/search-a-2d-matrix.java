class Solution {
    // public boolean searchMatrix(int[][] m, int t) {
    //     int i=m.length-1,j=0;
    //     // j=m[0].length;
    //     int curr=m[i][j];


    //    while(i<)
    // }

    public boolean searchMatrix(int[][] m, int t) {
        int i=0,j=m[0].length-1;

        while(i<m.length && j>=0){
            if(m[i][j]==t){
                return true;
            }
            if(m[i][j]<t){
                i++;
            }
            else if(m[i][j]>t){
                j--;
            }
        }
        return false;

    }
       
}