import java.util.ArrayList;
import java.util.List;

class Solution {
    public int dfs(List<List<Pair<Integer, Integer>>> adj, int par, int sig, int dist, Pair<Integer, Integer> node) {
        int ans = 0;
        for (Pair<Integer, Integer> v : adj.get(node.first)) {
            if (!v.first.equals(par)) {
                ans += dfs(adj, node.first, sig, dist + node.second, v);
            }
        }
        if (((dist + node.second) % sig) == 0)
            ans++;
        return ans;
    }

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;
        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(new Pair<>(e[1], e[2]));
            adj.get(e[1]).add(new Pair<>(e[0], e[2]));
        }

        List<List<Integer>> aux = new ArrayList<>();
        //aux[i] will store the numbers of servers satisfying the signal constraint
        //for all adjacent paths
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            aux.add(new ArrayList<>());
            for (Pair<Integer, Integer> v : adj.get(i)) {
                int temp = dfs(adj, i, signalSpeed, 0, v);   //it will return the number of servers satisfying the constraint which can be reached from ith node through vth node
                aux.get(i).add(temp);
                sum += temp;     // Sum is the total number of GOod Nodes 
            }
            int ans_ = 0;
            for (int x : aux.get(i)) {
                ans_ += x * (sum - x);   //take all servers from one path and make pair with all other servers
            }
            ans[i] = ans_ / 2;  //devide by 2 two remove repeatation of (i,j) and (j,i)
        }

        return ans;
    }

    static class Pair<K, V> {
        K first;
        V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }
}

class Solution1 {
    List<int[]> []list;
    int n;
    
    private int dfs(int parent, int curr, int w, int signalSpeed){
        int cnt = 0;
        if(w%signalSpeed == 0) cnt++;
        for(int[] e:list[curr]){
            if(e[0] != parent){
                cnt += dfs(curr, e[0], w+e[1], signalSpeed);
            }
        }
        return cnt;
    }
    
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        n = edges.length+1;
        list = new ArrayList[n];
        for(int i=0; i<n; i++){
            list[i] = new ArrayList();
        }
        
        for(int []e:edges){
            list[e[0]].add(new int[]{e[1], e[2]});
            list[e[1]].add(new int[]{e[0], e[2]});
        }
        
        int[] res = new int[n];
        for(int i=0; i<n; i++){
            int node = 0, pair =0;
            for(int[] e:list[i]){
                int cnt = dfs(i, e[0], e[1], signalSpeed);
                pair+=node*cnt;
                node += cnt;
            }
            res[i] = pair;
        }
        return res;
    }
}