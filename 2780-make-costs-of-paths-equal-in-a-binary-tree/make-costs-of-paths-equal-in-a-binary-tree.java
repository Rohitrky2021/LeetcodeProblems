class Solution {
    public int minIncrements(int n, int[] cost) {
        int[] cb = new int[n]; // cost from bottom
        int i = n;
        int res = 0;
        while(i>1){
            int r = i--;
            int l = i--;
            // if these are leaf nodes
            if(2*r > n){
                int max = Math.max(cost[l-1],cost[r-1]);
                cb[l-1] = max;
                cb[r-1] = max;
                res += Math.abs(cost[l-1]-cost[r-1]);
                continue;
            }

            if(cost[l-1] + cb[2*l] <= cost[r-1] + cb[2*r]){
                int k = cost[r-1] + cb[2*r] - cb[2*l] - cost[l-1];
                // k is added to l
                res += k;
                cb[l-1] = cost[r-1] + cb[2*r];
                cb[r-1] = cost[r-1] + cb[2*r];
            }else{
                int k = cost[l-1] + cb[2*l] - cost[r-1] - cb[2*r];
                res += k;
                cb[l-1] = cost[l-1] + cb[2*l];
                cb[r-1] = cost[l-1] + cb[2*l];
            }
        }
        return res;
    }
}