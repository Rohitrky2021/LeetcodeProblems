import java.util.*;
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int maxRank = 0;
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        // Construct adjency list 'adj', where adj[node] stores all nodes connected to 'node'.
        for (int[] road : roads) {
            adj.computeIfAbsent(road[0], k -> new HashSet<>()).add(road[1]);
            adj.computeIfAbsent(road[1], k -> new HashSet<>()).add(road[0]);
        }

        // Iterate on each possible pair of nodes.
        for (int node1 = 0; node1 < n; ++node1) {
            for (int node2 = node1 + 1; node2 < n; ++node2) {
                int currentRank = adj.getOrDefault(node1, Collections.emptySet()).size() +
                                  adj.getOrDefault(node2, Collections.emptySet()).size();

                // Find the current pair's respective network rank and store if it's maximum till now.
                if (adj.getOrDefault(node1, Collections.emptySet()).contains(node2)) {
                    --currentRank;
                }
                maxRank = Math.max(maxRank, currentRank);
            }
        }
        // Return the maximum network rank.
        return maxRank;
    }
}

// class Solution {
//     static class edge {
//         int source;
//         int dest;

//         edge(int s, int d) {
//             this.source = s;
//             this.dest = d;
//         }
//     }

//     public int maximalNetworkRank(int n, int[][] roads) {
//         ArrayList<edge> graph[] = new ArrayList[n];
//         for (int i = 0; i < n; i++) {
//             graph[i] = new ArrayList<>();
//         }

//         for (int i = 0; i < roads.length; i++) {
//             int source = roads[i][0];
//             int dest = roads[i][1];
//             graph[source].add(new edge(source, dest));
//             graph[dest].add(new edge(dest, source));
//         }

//         int maxRank = 0;
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 int rank = graph[i].size() + graph[j].size();
//                 for (edge e : graph[i]) {
//                     if (e.dest == j) {
//                         rank--;
//                         break;
//                     }
//                 }
//                 maxRank = Math.max(maxRank, rank);
//             }
//         }

//         return maxRank;
//     }
// }
