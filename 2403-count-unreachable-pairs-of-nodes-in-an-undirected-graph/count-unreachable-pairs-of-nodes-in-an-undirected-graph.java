class Solution {
    public long countPairs(int n, int[][] edges) {
        UnionFind dsu = new UnionFind(n);

        // Union all the edges to create connected components
        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }

        // Map to count the size of each component
        Map<Integer, Integer> componentSizeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);  // Find the root (or representative) of each component
            componentSizeMap.put(root, componentSizeMap.getOrDefault(root, 0) + 1);
        }

        // Total number of pairs of nodes = n * (n - 1) / 2
        long totalPairs = (long) n * (n - 1) / 2;

        // Subtract pairs within each component (as they are reachable)
        for (int size : componentSizeMap.values()) {
            totalPairs -= (long) size * (size - 1) / 2;
        }

        return totalPairs;
    }

    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        // Find with path compression
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        // Union by rank
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
}
