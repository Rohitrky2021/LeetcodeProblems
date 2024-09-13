class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n=arr.length;

        int x[]=new int[n];
        int ans[]=new int[queries.length];

        x[0]=arr[0];
        for(int i=1;i<n;i++){
            x[i]=arr[i]^x[i-1];
        }
        int i=0;
        for(int q[]:queries){
            int l=q[0];
            int r=q[1];
            if(l-1>=0) ans[i++]=x[l-1]^x[r];
           else ans[i++]=x[r];

        }


        return ans;
    }
}