class Solution {
    public int missingNumber(int[] arr) {
        int max=findMax(arr);
        if(arr.length<max){
            return max;
        }
                if(arr.length>max){
            return max+1;
        }
        //                 if(arr.length==max){
        //     return max+1;
        // }
        // if(isSorted(arr)){
        //     return arr[arr.length-1]+1;
        // }
        int xor=0^0;
        for(int i=0;i<arr.length;i++){
            xor^=arr[i];
        }
                for(int i=0;i<arr.length+1;i++){
            xor^=i;
        }
        return xor;

}
    public static boolean isSorted(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
      public static int findMax(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("The array is empty.");
        }

        int maxVal = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];
            }
        }

        return maxVal;
    }

}