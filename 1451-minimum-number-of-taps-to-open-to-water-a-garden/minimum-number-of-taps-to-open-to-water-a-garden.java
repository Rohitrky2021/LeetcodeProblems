class Solution {

    public int minTaps(int n, int[] ranges) {
        int taps[][] = new int[ranges.length][3];
        for (int i = 0; i < taps.length; i++) {
            taps[i][0] = i;
            taps[i][1] = i - ranges[i];
            taps[i][2] = i + ranges[i];
        }

        Arrays.sort(taps, (a, b) -> a[1] - b[1]);

        int minTaps = 0;
        int currEnd = 0;
        int nextEnd = 0;

        for (int i = 0; i < taps.length && currEnd < n;) {
            while (i < taps.length && taps[i][1] <= currEnd) {
                nextEnd = Math.max(nextEnd, taps[i][2]);
                i++;
            }

            if (currEnd == nextEnd) {
                System.out.println("No solution possible.");
                return -1;
            }

            currEnd = nextEnd;
            minTaps++;
        }

        System.out.println("Minimum number of taps required: " + minTaps);

        return minTaps;
    }
}
