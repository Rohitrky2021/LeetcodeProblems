class Solution1 {

    // BFS so O(V+E )
    public boolean isBipartite(int[][] graph) {
            // public static boolean Bipartite(ArrayList<edge>[] graph){
        int col[]=new int[graph.length];

        for(int i=0;i<graph.length;i++){
            col[i]=-1;
            
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            // q.add(col[i]);
            if(col[i]==-1){  // Col of i he used hoga for the visite ones checking also 
                q.add(i);
                col[i]=0;//red
                while(!q.isEmpty()){
                    int curr=q.remove();
                    for(int j=0;j<graph[curr].length;j++){
                        // edge e=;
                        if(col[graph[curr][j]]==-1){
                            int nextCol=col[curr]==0?1:0;
                            // col[e.dest]=1;//black
                            col[graph[curr][j]]=nextCol;
                            q.add(graph[curr][j]);
                        }
                        else if(col[graph[curr][j]]==col[curr]){
                            return false;//not bipartitie
                        }
                        // else()

                    }
                }
            }
            // if(col[i]==0)
        }
        return true;


    }
    
}


// M 2--> Using DSU 
//BFS
class Solution2 {
    static int[] color;
    public boolean isBipartite(int[][] g) {
        color = new int[g.length];
        return Solve(g);
    }
    public static boolean Solve(int[][] g) {
        for (int i = 0; i < g.length; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                Queue<Integer> que = new ArrayDeque<>();
                que.add(i);
                while (!que.isEmpty()) {
                    int u = que.poll();
                    for (int v : g[u]) {
                        if (color[v] == color[u]) return false;
                        if (color[v] == 0) {
                            que.add(v);
                            color[v] = -color[u] ;
                        }
                    }
                }

            }
        }
        return true;
    }

}

//DSU/Union Find (Union by Rank)


class Solution {
    public boolean isBipartite(int[][] graph) {
        Dsu dsu = new Dsu(graph.length);
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (dsu.isSame(i, graph[i][j])) return false;
                dsu.unionSets(graph[i][0], graph[i][j]);
            }
        }
        return true;
    }

    public static class Dsu {
        int n, numberOfset;
        int[] parent, setSize, rank;

        Dsu(int n) {
            this.n = n;
            numberOfset = n;
            parent = new int[n];
            rank = new int[n];
            setSize = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                setSize[i] = 1;
            }
        }

        public int findSet(int u) {
            if (u == parent[u]) return u;
            return parent[u] = findSet(parent[u]);
        }

        public boolean union(int u, int v) {
            u = findSet(u);
            v = findSet(v);
            if (u == v) return false;
            if (setSize[u] <= setSize[v]) {
                int temp = u;
                u = v;
                v = temp;
            }
            parent[v] = u;
            setSize[u] += setSize[v];
            numberOfset--;
            return true;
        }

        public void unionSets(int a, int b) {//union by rank
            a = findSet(a);
            b = findSet(b);
            if (a != b) {
                if (rank[a] < rank[b]) {
                    int t = a;
                    a = b;
                    b = t;
                }
                parent[b] = a;
                if (rank[a] == rank[b]) {
                    rank[a]++;
                }
            }
        }

        public boolean isSame(int u, int v) {
            return findSet(u) == findSet(v);
        }
    }

}


