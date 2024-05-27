class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);

        int prev=arr[1]-arr[0];
        for(int i=1;i<arr.length;i++){
            int diff=arr[i]-arr[i-1];

            if(diff!=prev)return false;

            prev=diff;

        }
        return true;
    }
}