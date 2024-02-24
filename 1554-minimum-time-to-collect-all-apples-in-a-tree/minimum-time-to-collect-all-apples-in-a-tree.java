class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u); // Assuming undirected graph
        }

        return dfsOfGraph(0, graph, hasApple);
    }

    public int dfsOfGraph(int node, ArrayList<Integer>[] adj, List<Boolean> hasApple) {
        boolean[] vis = new boolean[adj.length];
        return dfs(node, adj, hasApple, vis);
    }

    public int dfs(int node, ArrayList<Integer>[] adj, List<Boolean> hasApple, boolean[] vis) {
        vis[node] = true;
        int count = 0; // Initialize count for this node

        for (int it : adj[node]) { // Iterate over neighbors of 'node'
            if (!vis[it]) {
                count += dfs(it, adj, hasApple, vis);
            }
        }

        if ((count > 0 || hasApple.get(node)) && node != 0) { // If the node has apples or it's not the root
            return count + 2; // Add 2 for the time to go to this node and return back
        }

        return count; // Return count of apples in this subtree
    }
}
