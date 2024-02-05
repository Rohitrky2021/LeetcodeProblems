class Solution {
    public boolean equationsPossible(String[] eqn) {
        UnionFind uf = new UnionFind(26);
         // Assuming only lowercase English letters are used in equations
        for (String s : eqn) {
            // char check[] = s.toCharArray();

              
              if (s.charAt(1)== '=') 
                uf.union_set(s.charAt(0) - 'a', s.charAt(3)- 'a');

        }

        for (String s : eqn) {
            char check[] = s.toCharArray();

            if (check[1] == '!') {
                int x1 = check[0] - 'a'; // Adjust index to 0-based for lowercase English letters
                int x2 = check[3] - 'a';
                if (uf.find(x1) == uf.find(x2)) return false;
            }  
            
        }

        return true;
    }

    static class UnionFind {
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

        public void union_set(int x, int y) {
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
