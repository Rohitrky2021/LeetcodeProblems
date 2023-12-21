class Solution {

    public int maxWidthOfVerticalArea(int[][] points) {
        int max = (int) -1e9;
        int prevx = 0;
        Arrays.sort(points, Comparator.comparingDouble(o -> o[0]));
        prevx = points[0][0];
        for (int i = 1; i < points.length; i++) {
            max = Math.max(max, points[i][0] - prevx);
            prevx = points[i][0];
            System.out.println(max);
        }
        // for(int[] x:points){
        //     max=Math.max(max,x[0]-prevx);
        //     prevx=x[0];
        // System.out.println(max);
        // }
        return max;
    }
}


