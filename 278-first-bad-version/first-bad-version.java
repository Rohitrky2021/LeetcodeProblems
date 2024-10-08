/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {

    public int firstBadVersion(int n) {
        int l = 1;
        int r = n ;
        int mid = l + (r - l) / 2;
        while (l <= r) {
            if (isBadVersion(mid)==true) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

            mid = l + (r - l) / 2;
        }
        // System.out.println(l + " " + r);
        return l;
    }
}
