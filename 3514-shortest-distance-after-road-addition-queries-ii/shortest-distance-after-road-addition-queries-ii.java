class Solution {
    // Inner class representing the Disjoint Set Union (DSU) structure
    static class DSU {
        private int[] parent; // Array to store the parent of each node
        private int[] size;   // Array to store the size of each component
        private int numCC;    // Number of connected components

        // Constructor to initialize the DSU with 'n' nodes
        public DSU(int n) {
            parent = new int[n];
            size = new int[n];
            numCC = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i; // Each node is its own parent initially
                size[i] = 1;   // Each component has size 1 initially
            }
        }

        // Find the representative (root) of the component containing 'v'
        public int find(int v) {
            if (v != parent[v]) {
                parent[v] = find(parent[v]); // Path compression
            }
            return parent[v];
        }

        // Union two components containing 'u' and 'v'
        public void unite(int u, int v) {
            u = find(u); // Find root of u
            v = find(v); // Find root of v
            if (u != v) {
                numCC--; // Decrease the number of connected components
                if (u < v) {
                    int temp = u;
                    u = v;
                    v = temp;
                }
                parent[v] = u; // Make u the root of v
                size[u] += size[v]; // Update size of the new root
            }
        }

        // Get the current number of connected components
        public int getNumCC() {
            return numCC;
        }
    }

    // Main function to compute the shortest distance after each query
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        DSU dsu = new DSU(n); // Initialize DSU with 'n' nodes
        int[] ans = new int[queries.length]; // Array to store results of each query

        // Iterate through each query
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int L = dsu.find(q[0]); // Find the root of the component containing q[0]
            int R = dsu.find(q[1] - 1); // Find the root of the component containing q[1] - 1

            // Connect all nodes between L and R if they are not already connected
            for (int j = L; j < R;) {
                if (dsu.find(j) + 1 <= R) {
                    dsu.unite(j, dsu.find(j) + 1); // Union nodes j and j+1
                } else {
                    break;
                }
                j = dsu.find(j); // Move to the next component
            }

            // Calculate the shortest path from city 0 to city n-1
            ans[i] = dsu.getNumCC() - 1; // The number of edges needed is the number of components - 1
        }

        return ans; // Return the result array
    }
}
