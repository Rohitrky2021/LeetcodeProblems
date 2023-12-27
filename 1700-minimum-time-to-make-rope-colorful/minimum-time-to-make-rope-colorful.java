class Solution {
    public int minCost(String colors, int[] time) {
        int sum = 0;
        char[] col = colors.toCharArray();

        for (int i = 0; i < col.length - 1; i++) {
            if (col[i] == col[i + 1]) {
                if (time[i] < time[i + 1]) {
                    sum += time[i];
                } else {
                    sum += time[i + 1];
                    // swap to take forward the greateer time , after we accounted the smaller one
                    int temp = time[i + 1];
                    time[i + 1] = time[i];
                    time[i] = temp;
                }
            }
        }
            return sum;

    }
}
