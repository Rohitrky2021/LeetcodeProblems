class Solution {
    public int trap(int[] h) {
        int n=h.length;
        int left[]=new int[n];
         left[0]=h[0];

        for(int i=1;i<n;i++){
            left[i]=Math.max(h[i],left[i-1]);
        }  

        int right[]=new int[n];
        right[n-1]=h[n-1];
        for(int i=n-2;i>=0;i--){
            right[i]=Math.max(h[i],right[i+1]);
        }
        int trap=0;
        for(int i=0;i<n;i++){
            // int maxh=Math.min(Math.abs(right[i]-left[i]));---> if want the max section 
            int maxh=Math.min(right[i],left[i]);
           trap+=maxh-h[i];
        } 
        return trap;     
    }
}