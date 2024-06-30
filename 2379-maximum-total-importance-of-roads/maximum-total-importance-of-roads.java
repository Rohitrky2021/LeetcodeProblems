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

// 2nd hamra ek Array se hi kaam hojaata as we know only the frequenc count
class Solution2 {
    public long maximumImportance(int n, int[][] roads) {
        int[] freq = new int[n];
        for (int[] road: roads) {
            ++freq[road[0]];
            ++freq[road[1]];
        }
        Arrays.sort(freq);

        long importanceSum = 0;
        for (int i = 0; i < n; ++i) {
            importanceSum += freq[i] * (i + 1L);
        }

        return importanceSum;
    }
}

//  WIthout sorting method 
class Solution3 {
    public long maximumImportance(int n, int[][] roads) {
        int[] br = new int[n];
        for(int[] r : roads){
            br[r[0]]++;
            br[r[1]]++;
        }
        int[] cnt = new int[n];
        for(int b : br){
            cnt[b]++;
        }
        long sum = 0;
        long val = 1;
        for(long i = 0; i < n; i++){
            for(int j = 0; j < cnt[(int)i]; j++){
                sum += i*val++;
            }
        }
        return sum;
    }
}