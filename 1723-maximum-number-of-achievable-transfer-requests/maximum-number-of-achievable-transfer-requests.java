class Solution {
    int res = 0;

    public int maximumRequests(int n, int[][] requests) {
        // b stores people in each building
        int[] b = new int[n];
        // all buildings are balanced at start
        Arrays.fill(b, 0);
        dfs(requests, 0, b, 0);
        return res;
    }

    public void dfs(int[][] requests, int index, int[] b, int count){
        // all requests processed, check for imbalance
        if (index == requests.length){
            for (int i : b){
                if (i != 0){
                    // if imbalance exists, do nothing and return
                    return;
                }
            }
            // all buildings are balanced, update maximum requests
            res = Math.max(res, count);
            return;
        }

        // for each request we have two options: process or skip

        // skip request
        dfs(requests, index+1, b, count);

        // process request
        b[requests[index][0]]--;
        b[requests[index][1]]++;
        dfs(requests, index+1, b, count+1);
        b[requests[index][0]]++;
        b[requests[index][1]]--;
    }
}