class Solution {
        public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);

        long sum = 0L;

        for (int x : batteries) {
            sum += x;
        }

        for (int i = batteries.length - 1; ; i--) {
            if (batteries[i] <= sum / n) {
                return sum / n;
            }

            sum -= batteries[i];
            --n;
        }
    }
}