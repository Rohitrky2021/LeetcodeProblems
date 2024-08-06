import java.util.*;

public class Solution {
    static class DisjointSetUnion {
        static int n;
        static int[] rank;
        static int[] par;

        static void init(int x) {
            n = x;
            rank = new int[n];
            par = new int[n];
            for (int i = 0; i < n; i++) {
                par[i] = i;
                rank[i] = 0;
            }
        }

        static int find(int x) {
            if (x == par[x]) {
                return x;
            }
            par[x] = find(par[x]); // Path compression
            return par[x];
        }

        static void union(int a, int b) {
            int parA = find(a);
            int parB = find(b);

            if (parA != parB) {
                if (rank[parA] > rank[parB]) {
                    par[parB] = parA;
                } else if (rank[parA] < rank[parB]) {
                    par[parA] = parB;
                } else {
                    par[parB] = parA;
                    rank[parA]++;
                }
            }
        }
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // Initialize DSU
        DisjointSetUnion.init(n);

        // Adjacency list for the graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add initial edges (i -> i + 1)
        for (int i = 0; i < n - 1; i++) {
            adjList.get(i).add(i + 1);
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            
            // Add the new edge
            adjList.get(u).add(v);

            // Perform BFS to find the shortest path from 0 to n-1
            result[i] = bfs(adjList, 0, n - 1);
        }

        return result;
    }

    private int bfs(List<List<Integer>> adjList, int start, int end) {
        int n = adjList.size();
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        queue.add(start);
        visited[start] = true;
        distance[start] = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            if (node == end) {
                return distance[node];
            }
            
            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    queue.add(neighbor);
                }
            }
        }
        
        return -1; // If there's no path from start to end
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test case 1
        int[][] queries1 = {{2, 4}, {0, 2}, {0, 4}};
        System.out.println(Arrays.toString(sol.shortestDistanceAfterQueries(5, queries1))); // [3, 2, 1]

        // Test case 2
        int[][] queries2 = {{0, 3}, {0, 2}};
        System.out.println(Arrays.toString(sol.shortestDistanceAfterQueries(4, queries2))); // [1, 1]
    }
}
