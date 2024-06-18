class Solution {
     public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int activitys[][] = new int[profit.length][3];

        for (int i = 0; i < profit.length; i++) {
            activitys[i][0] = i;
            activitys[i][1] = profit[i];
            activitys[i][2] = difficulty[i];
        }

        Arrays.sort(activitys, Comparator.comparingInt(o -> o[2]));

        TreeMap<Integer, Integer> hm = new TreeMap<>();
        int max = 0;
        for (int[] x : activitys) {
            if (x[1] > max) {
                max = x[1];
            }
            x[1] = max;
            hm.put(x[2], x[1]);
        }

        int sum = 0;
        for (int i = 0; i < worker.length; i++) {
            Integer key = hm.floorKey(worker[i]);
            if (key != null) {
                sum += hm.get(key);
            }
        }

        return sum;
    }
    
}