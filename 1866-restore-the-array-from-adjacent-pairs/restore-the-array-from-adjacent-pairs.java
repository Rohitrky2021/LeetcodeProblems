import java.util.*;

class Solution {

    public int[] restoreArray(int[][] ap) {
        Map<Integer, List<Integer>> m = new HashMap<>();

        for (int[] x : ap) {
            m.computeIfAbsent(x[0], k -> new ArrayList<>()).add(x[1]);
            m.computeIfAbsent(x[1], k -> new ArrayList<>()).add(x[0]);
        }

        int s = 0;
        for (Map.Entry<Integer, List<Integer>> e : m.entrySet()) {
            if (e.getValue().size() == 1) {
                s = e.getKey();
                break;
            }
        }

        int[] r = new int[ap.length + 1];
        Set<Integer> v = new HashSet<>();
        restoreArrayDFS(m, s, r, v, 0);

        return r;
    }

    private void restoreArrayDFS(Map<Integer, List<Integer>> m, int c, int[] r, Set<Integer> v, int i) {
        r[i] = c;
        v.add(c);

        for (int n : m.get(c)) {
            if (!v.contains(n)) {
                restoreArrayDFS(m, n, r, v, i + 1);
                break;
            }
        }
    }
}
