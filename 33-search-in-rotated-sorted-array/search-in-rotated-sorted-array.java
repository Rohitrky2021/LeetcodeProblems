class Solution {
    public int search(int[] arr, int target) {
        int  l = 0;
        int r = arr.length - 1;
        return searchi(arr,target,l,r);
    }

    public int searchi(int[] arr, int target,int l,int r) {
        // l = 0;
        // r = arr.length - 1;
        int mid = l + (r - l) / 2;
        if(l>r){
            return -1;
        }
        if(arr[mid]==target){
            return mid;
        }

        // Where the Mid lies  
        // on L1-->
        if(arr[mid]>=arr[l]){
            // left
            if(arr[l]<=target && target<=arr[mid]){
                return searchi(arr, target,l,mid-1);
            }
            // rigth
            else{
                return searchi(arr, target, mid+1, r);
            }
        }
        // on L2--->
        else{
            if(target>=arr[mid] && target<=arr[r])
            // left
                 
            return searchi(arr, target, mid+1, r);
            // right
            else{
           return searchi(arr, target,l,mid-1);
            }

        }

    }

}