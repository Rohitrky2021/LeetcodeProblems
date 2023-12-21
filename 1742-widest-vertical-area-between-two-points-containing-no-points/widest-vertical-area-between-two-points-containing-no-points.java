class Solution1 {

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

 

class Solution2 {

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

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {

        SortedSet<Integer> xPoints = new TreeSet<Integer>();
        for(int i=0;i<points.length;i++){
            xPoints.add(points[i][0]);
        }
        int max = 0;
        boolean isFirst = true;
        int last = 0;
        Iterator<Integer> iterator = xPoints.iterator(); 
        if (iterator.hasNext()){   
            last =  iterator.next();
        }
        while (iterator.hasNext()){    
            Integer point = iterator.next();       
            max = Math.max(point-last,max);
            last = point;
            
        }
        return max;
    }
}
