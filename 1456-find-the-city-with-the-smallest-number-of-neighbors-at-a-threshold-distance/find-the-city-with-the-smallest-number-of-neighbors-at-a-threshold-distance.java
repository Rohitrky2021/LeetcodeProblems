import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public int findTheCity(int n, int[][] edges, int threshold) {
        // Convert edges to adjacency matrix
        int[][] adjMatrix = new int[n][n];
        for (int[] edge : edges) {
            adjMatrix[edge[0]][edge[1]] = edge[2];
            adjMatrix[edge[1]][edge[0]] = edge[2]; // Assuming undirected graph
        }

        int[][] allDistances = allPairsShortestPath(adjMatrix, threshold);

        int maxCount = Integer.MAX_VALUE;
        int cityWithMaxReachableNodes = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (allDistances[i][j] != Integer.MAX_VALUE && i != j) {
                    count++;
                }
            }
            if (count <= maxCount) {
                maxCount = count;
                cityWithMaxReachableNodes = i;
            }
        }

        return cityWithMaxReachableNodes;
    }

    private int[][] allPairsShortestPath(int[][] edges, int threshold) {
        int V = edges.length;
        int[][] allDistances = new int[V][V];

        for (int i = 0; i < V; i++) {
            allDistances[i] = dijkstra(edges, i, threshold);
        }

        return allDistances;
    }

    private int[] dijkstra(int[][] edges, int src, int threshold) {
        int V = edges.length;
        int[] dist = new int[V];
        boolean[] vis = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE); // Initialize distances to infinity
        dist[src] = 0; // Distance to source is 0

        // Priority queue to select the edge with the smallest weight
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{src, 0});

        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];

            if (vis[u]) continue;
            vis[u] = true;

            for (int v = 0; v < V; v++) {
                int wt = edges[u][v];

                if (wt != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v] && dist[u] + wt <= threshold) {
                    dist[v] = dist[u] + wt;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        return dist;
    }
}
