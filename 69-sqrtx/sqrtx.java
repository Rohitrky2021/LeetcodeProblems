class Solution {
    public int mySqrt(int x) {
     if (x == 0 || x == 1) {
            return x;
        }

        long l = 1;
        long h = x;
        long ans = -1;

        while (l <= h) {
            long mid = l + (h - l) / 2;

            if (mid * mid == x) {
                return (int) mid;
            }
            else if(mid*mid>x){
                h=mid-1;
                ans=h;

            }else{
                l=mid+1;
            }
        }

        return (int)ans;
        
    }
}