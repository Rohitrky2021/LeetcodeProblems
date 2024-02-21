class Solution {
    public int minDistance(String s, String t) {
        int n=s.length();
        int m=t.length();

        return n+m-2*space(s,t,n,m);
        
    }
  public   int space(String s, String t,int n,int m){
        int[] prev = new int[m+1];//m is always larger string
        int[] curr = new int[m+1];
        for(int j=0; j<=m; j++){
            prev[j] = 0;
        }

        for(int i=1;i<=n;i++){
            for(int j = 1; j<=m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    curr[j] = 1 + prev[j-1];
                    continue;
                }
                curr[j] = Math.max(curr[j-1], prev[j]);
            }
            prev=curr.clone(); // Deep clone Not work here was GIving WR
        }
        return prev[m];
    }
}