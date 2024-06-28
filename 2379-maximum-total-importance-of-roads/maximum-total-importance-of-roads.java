class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long indegree[] = new long[n];

        for(int x[] : roads){
            indegree[(int)x[0]]++;
            indegree[(int)x[1]]++;
        }
      
        long check[][] = new long[n][2];

        for (int i = 0; i < n; i++) {
            check[i][0] = i + 1;
            check[i][1] = indegree[i];
        }

        Arrays.sort(check, (a, b) -> Long.compare(b[1], a[1]));

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += check[i][1] * (n - i);
        }

        return ans;
    }
}
