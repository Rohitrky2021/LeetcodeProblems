class Solution {

    public boolean canFinish(int numCourses, int[][] edges) {
        Arrays.sort(edges, Comparator.comparingInt(o -> o[0]));
        int v = numCourses;
        // int[][] edges = {{0, 1}, {0, 3}, {1, 2}, {3, 2}, {3, 1}, {1, 0}};

        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int source = edge[0];
            int dest = edge[1];
            graph[source].add(new Edge(source, dest));
        }

        return !iscycle(graph);
    }

    static class Edge {
        int source;
        int dest;

        Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    // public static void main(String[] args) {

    // }

    public static boolean iscycle(ArrayList<Edge>[] graph) {
        int v = graph.length;
        boolean[] visited = new boolean[v];
        boolean[] stack = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (iscycleUtil(graph, i, visited, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean iscycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited, boolean[] stack) {
        visited[curr] = true;
        stack[curr] = true;

        for (Edge e : graph[curr]) {
            if (stack[e.dest]) {
                return true;
            } else if (!visited[e.dest] && iscycleUtil(graph, e.dest, visited, stack)) {
                return true;
            }
        }

        stack[curr] = false;
        return false;
    }
}
