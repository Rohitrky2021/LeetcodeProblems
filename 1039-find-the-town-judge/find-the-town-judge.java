class Solution {
    public int findJudge(int n, int[][] t) {
        // int n=t.length;
        int hash[]=new int[n];
        int possible=-1;

        for(int[] x:t){
            hash[x[1]-1]++;
        }

        for(int i=0;i<n;i++){
            if(hash[i]==n-1) possible=i+1;
        }

        for(int[] x:t){
           if(x[0]==possible)return -1;
        }

       return possible; 
        
    }
}