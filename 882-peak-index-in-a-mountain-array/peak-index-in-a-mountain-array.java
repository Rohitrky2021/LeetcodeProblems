class Solution {

    // public int peakIndexInMountainArray(int[] arr) {
    //     int count =0;
    //     for(int i=1;i<arr.length-1;i++){

    //         if(arr[i]>arr[i+1] && arr[i]>arr[i-1]  ){
    // return i;}
    // // else if(arr[arr.length-1]==1){
    // //     count++;
    // // }

    //     }
    // return count ;

    // }

    // using Binary search now ;

    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int mid = l + (r - l) / 2;
        while (l < r) {
            if (arr[mid] > arr[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }

            mid = l + (r - l) / 2;
        }
        return l ;
    }
}
