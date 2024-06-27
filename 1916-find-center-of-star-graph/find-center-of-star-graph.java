class Solution {
    public int findCenter(int[][] edges) {

        int n=edges.length+1;
        int indegre[]=new int[n];

      for (int i = 0; i < n-1; i++) {
            int v=i;
            for (int j = 0; j < 2 ; j++) {
                int m=edges[i][j];
                indegre[m-1]++;
            }
        }

        for(int i=0;i<=n;i++){
            if(indegre[i]==n-1)return i+1;
        }

        return 0;
    }
}