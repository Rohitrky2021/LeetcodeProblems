class Solution {

    public int minSpeedOnTime(int[] dist, double hour) {
        //  public static void main(String[] args) {
        int l = 1;
        int r = 10000000;int mins=-1;
        int mid = l + (r - l) / 2;
        while (l <= r) {
            if (helper(mid, dist, hour)) {
                r = mid - 1;
                mins=mid;
            } else {
                l = mid + 1;
            }

            mid = l + (r - l) / 2;
        }
        // if (l== dist.length - 1 && helper(mid, dist, hour)){
        //     return -1;
        // }
        
        // System.out.println(l + " " + r);
        return mins;
        // }
    }

    public boolean helper(int n, int arr[], double k) {
        double check = 0,m=0;
        for (int i = 0; i < arr.length; i++) {
            m= (double) arr[i] / n;

            check+=(i==arr.length-1 ? m:Math.ceil(m));
        }
        System.out.println(check + " " + k);

        return check <= k;
    }
}
