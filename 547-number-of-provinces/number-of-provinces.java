import java.util.*;

class Solution {
    public int findCircleNum(int[][] g) {
        int V = g.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (g[i][j] == 1) {
                    adj.get(i).add(j); // Add edge (i, j) to the adjacency list
                }
            }
        }

        // write your code here
        boolean[] visited = new boolean[V];
        int count = 0; // Counter for the number of connected components

        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                dfs(adj, v, visited);
                count++;
            }
        }

        return count;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited) {
        visited[src] = true;
        for (int neighbor : adj.get(src)) {
            if (!visited[neighbor]) {
                dfs(adj, neighbor, visited);
            }
        }
    }
}
