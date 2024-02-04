class Solution {

    static class Edge {
        int source;
        int dest;

        Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int v = numCourses;
        // int[][] edges = {{0, 1}, {0, 3}, {1, 2}, {3, 2}, {3, 1}, {1, 0}};

        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : prerequisites) { // corrected variable name
            int source = edge[1];
            int dest = edge[0];
            graph[source].add(new Edge(source, dest));
        }

        return topSort(graph, v); // Corrected method call
    }

    static int[] topSort(ArrayList<Edge>[] graph, int v) { // Corrected method signature
        int indeg[] = new int[v];

        // 1. Calculate Indegree 
        calcIndeg(graph, indeg);
        int count=0;
        ArrayList<Integer> ans=new ArrayList<>(); // Corrected ArrayList spelling

        // 2. Jinki Indegree==0 h unko Queue m daal do for a BFS start 
        Queue<Integer> q =  new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if(indeg[i] == 0){  // corrected comparison operator
                q.add(i);
                count++;
                ans.add(i);
            }
        }

        // NOrmal BFS 
        while(!q.isEmpty()){
            int curr = q.remove();
            // System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;       // corrected variable name
                if(indeg[e.dest] == 0){ // corrected comparison operator
                    q.add(e.dest); // corrected variable name
                    count++;
                    ans.add(e.dest);
                }
            }
        }

        if(count==v) {
            int[] result = new int[ans.size()];
            for (int i = 0; i < ans.size(); i++) {
                result[i] = ans.get(i);
            }
            return result;
        }

        return new int[]{};
    }

    static void calcIndeg(ArrayList<Edge> graph[], int indeg[]){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }
}
