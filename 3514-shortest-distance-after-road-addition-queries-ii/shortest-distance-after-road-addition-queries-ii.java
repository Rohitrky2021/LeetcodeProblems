class Solution {
    static class DSU {
        private int[] parent;
        private int[] size;
        private int numCC;

        public DSU(int n) {
            parent = new int[n];
            size = new int[n];
            numCC = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int v) {
            if (v != parent[v]) {
                parent[v] = find(parent[v]);
            }
            return parent[v];
        }

        public void unite(int u, int v) {
            u = find(u);
            v = find(v);
            if (u != v) {
                numCC--;
                if (u < v) {
                    int temp = u;
                    u = v;
                    v = temp;
                }
                parent[v] = u;
                size[u] += size[v];
            }
        }

        public int getNumCC() {
            return numCC;
        }
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        DSU dsu = new DSU(n);
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int L = dsu.find(q[0]);
            int R = dsu.find(q[1] - 1);

            for (int j = L; j < R;) {
                if (dsu.find(j) + 1 <= R) {
                    dsu.unite(j, dsu.find(j) + 1);
                } else {
                    break;
                }
                j = dsu.find(j);
            }

            ans[i] = dsu.getNumCC() - 1;
        }

        return ans;
    }
}
