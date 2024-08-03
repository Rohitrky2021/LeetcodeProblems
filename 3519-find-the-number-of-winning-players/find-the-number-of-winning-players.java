import java.util.Arrays;

class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        // Sort the 2D array with a comparator
        Arrays.sort(pick, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

        int ans[][] = new int[105][13];
        int freq[] = new int[105];
        int count = 0;

        for (int[] x : pick) {
            ans[x[0]][x[1]]++;

            if (ans[x[0]][x[1]] > x[0]) {
                freq[x[0]]++;
            }
        }

        for (int x : freq) {
            if (x != 0) count++;
        }

        return count;
    }
}
