import java.util.*;

class Solution {
    // Inner class to represent an Edge in the graph
    class Edge {
        int src; // Source vertex
        int dest; // Destination vertex
        int wt; // Weight of the edge

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    // Inner class to represent a Pair for the priority queue
    class Pair implements Comparable<Pair> {
        int node; // Node
        int dist; // Distance

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair o) {
            return this.dist - o.dist;
        }
    }

    // Method to find the network delay time
    public int networkDelayTime(int[][] times, int n, int k) {
        // Create a graph as an adjacency list
        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Populate the graph with edges
        for (int[] edge : times) {
            graph[edge[0]].add(new Edge(edge[0], edge[1], edge[2]));
        }

        // Run Dijkstra's algorithm
        int[] dist = dijkstra(graph, k, n);

        // Find the maximum distance
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxDist = Math.max(maxDist, dist[i]);
        }

        return maxDist;
    }

    // Dijkstra's algorithm to find the shortest path from the source to all nodes
    public int[] dijkstra(ArrayList<Edge>[] graph, int src, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        boolean[] vis = new boolean[n + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;

            if (!vis[u]) {
                vis[u] = true;

                for (Edge edge : graph[u]) {
                    int v = edge.dest;
                    int wt = edge.wt;

                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;
        System.out.println(sol.networkDelayTime(times, n, k)); // Output: 2
    }
}
