class Solution {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] list = new int[n][2];

        for (int i = 0; i < n; i++) {
            list[i][0] = profits[i];
            list[i][1] = capital[i];
        }

        Arrays.sort(list, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

        int i = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while (k-- > 0) {
            while (i < n && list[i][1] <= w) {
                pq.add(list[i][0]);
                i++;
            }

            if (!pq.isEmpty()) {
                w += pq.poll();
            }
        }

        return w;
    }

}