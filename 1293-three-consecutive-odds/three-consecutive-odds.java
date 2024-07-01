class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count=0;
        int max=0;

        for(int i=1;i<arr.length;i++){
            if(arr[i]%2!=0 && arr[i-1]%2!=0 ){
                count++;
            }else {
                count=0;
            }

            max=Math.max(max,count);

        }
        return max>=2;
        
    }
}