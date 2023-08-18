import java.util.*;

class Solution {
    static class edge {
        int source;
        int dest;

        edge(int s, int d) {
            this.source = s;
            this.dest = d;
        }
    }

    public int maximalNetworkRank(int n, int[][] roads) {
        ArrayList<edge> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < roads.length; i++) {
            int source = roads[i][0];
            int dest = roads[i][1];
            graph[source].add(new edge(source, dest));
            graph[dest].add(new edge(dest, source));
        }

        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = graph[i].size() + graph[j].size();
                for (edge e : graph[i]) {
                    if (e.dest == j) {
                        rank--;
                        break;
                    }
                }
                maxRank = Math.max(maxRank, rank);
            }
        }

        return maxRank;
    }
}
