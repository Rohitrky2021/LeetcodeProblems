import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;

        int low = 1;
        int high = position[n - 1] - position[0];
        
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (canPlaceBalls(position, n, m, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        
        return low;
    }
    
    private boolean canPlaceBalls(int[] position, int n, int m, int minDist) {
        int count = 1;
        int lastPos = position[0];
        
        for (int i = 1; i < n; i++) {
            if (position[i] - lastPos >= minDist) {
                count++;
                lastPos = position[i];
            }
            if (count >= m) {
                return true;
            }
        }
        
        return false;
    }
}
