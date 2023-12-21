class Solution2 {

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

 

class Solution {

    public int maxWidthOfVerticalArea(int[][] points) {
        // Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
         Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int max = Integer.MIN_VALUE;
        int prevX = points[0][0];

        for (int[] point : points) {
            max = Math.max(max, point[0] - prevX);
            prevX = point[0];
        }

        return max;
    }
}

class Solution3 {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        
        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            ans = Math.max(ans, points[i][0] - points[i - 1][0]);
        }
        
        return ans;
    }
}
