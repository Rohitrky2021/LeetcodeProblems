class Solution {
    public int regionsBySlashes(String[] grid) {
    int n = grid.length;
        int dots = n + 1;
        int parent[] = new int[dots * dots];
        int rank[] = new int[dots * dots];
        int count = 1;

        // Initialize parent and rank arrays
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        // Connect all boundary dots to a common root (dot at 0, 0)
        for (int i = 0; i < dots; i++) {
            for (int j = 0; j < dots; j++) {
                if (i == 0 || j == 0 || i == dots - 1 || j == dots - 1) {
                    int cellno = i * dots + j;
                    union(0, cellno, parent, rank);
                }
            }
        }

        // Process the grid to detect regions
        for (int i = 0; i < grid.length; i++) {
            char[] ch = grid[i].toCharArray();
            for (int j = 0; j < ch.length; j++) {
                if (ch[j] == '/') {
                    int cellno1 = (i * dots) + (j + 1);
                    int cellno2 = ((i + 1) * dots) + j;
                    boolean temp = union(cellno1, cellno2, parent, rank);
                    if (temp) count++;
                } else if (ch[j] == '\\') {
                    int cellno1 = i * dots + j;
                    int cellno2 = ((i + 1) * dots) + (j + 1);
                    boolean temp = union(cellno1, cellno2, parent, rank);
                    if (temp) count++;
                }
            }
        }

        return count;
    }


        // Union function to perform union of two sets
    public static boolean union(int x, int y, int parent[], int rank[]) {
        int lx = findLeader(x, parent), ly = findLeader(y, parent);
        if (lx != ly) {
            if (rank[lx] < rank[ly]) {
                parent[lx] = ly;
            } else if (rank[lx] > rank[ly]) {
                parent[ly] = lx;
            } else {
                parent[lx] = ly;
                rank[ly]++;
            }
            return false;
        }
        return true;
    }

    // Function to find the leader (root) of the set that element x belongs to
    public static int findLeader(int x, int parent[]) {
        if (parent[x] == x) return x;
        parent[x] = findLeader(parent[x], parent);
        return parent[x];
    }



}