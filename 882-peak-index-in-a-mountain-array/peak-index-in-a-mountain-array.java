class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int count =0;
        for(int i=1;i<arr.length-1;i++){

            if(arr[i]>arr[i+1] && arr[i]>arr[i-1]  ){
    return i;}
    // else if(arr[arr.length-1]==1){
    //     count++;
    // }
    
        }
    return count ;
        
    }
}