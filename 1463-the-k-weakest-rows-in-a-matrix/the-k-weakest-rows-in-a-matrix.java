class Solution {

    public int[] kWeakestRows(int[][] arr, int k) {
        PriorityQueue<row> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            int soldier = 0;
            int j = 0;
            while (arr[0].length > j && arr[i][j] == 1) {
                soldier++;
                j++;
            }
            pq.add(new row(soldier, i));
        }

        int ans[] = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = pq.remove().idx;
        }

        return ans;
    }

    public class row implements Comparable<row> {
        int soldier;
        int idx;

        row(int soldier, int idx) {
            this.idx = idx;
            this.soldier = soldier;
        }

        @Override
        public int compareTo(row r2) {
            if (this.soldier == r2.soldier) {
                return this.idx - r2.idx;
            } else {
                return this.soldier - r2.soldier;
            }
        }
    }
}
