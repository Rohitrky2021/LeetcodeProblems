import java.util.HashSet;

class Solution {
    public int makeConnected(int n, int[][] cns) {
        int m = cns.length;
        HashSet<Integer> s=new HashSet<>();

        if(m<n-1) return -1;
        UnionFind dsu = new UnionFind(n);

        for(int []x:cns){
            // if(dsu.find(x[0])!=dsu.find(x[1]))
            dsu.union(x[0],x[1]);
        }

        for(int i=0;i<n;i++){
            s.add(dsu.find(i));
        }

        return s.size()-1;
    }

    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++)
                parent[i] = i;
            rank = new int[size];
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            int xset = find(x), yset = find(y);
            if (xset == yset) {
                return;
            } else if (rank[xset] < rank[yset]) {
                parent[xset] = yset;
            } else if (rank[xset] > rank[yset]) {
                parent[yset] = xset;
            } else {
                parent[yset] = xset;
                rank[xset]++;
            }
        }
    }
}


