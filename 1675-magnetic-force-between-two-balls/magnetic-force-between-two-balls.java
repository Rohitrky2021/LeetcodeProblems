import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;

        int low = 1;
        int high = (position[n - 1] - position[0])/(m - 1); /// THIS OPTIMSE LINE IS MUST NEEDED 
        
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



class Solution2 {
    public int maxDistance(int[] arr, int m) {
        Arrays.sort(arr);
        int s = 1;
        int e = (arr[arr.length-1] - arr[0])/ (m - 1);
        int ans = 0;
        while(s<=e) {
            int mid = (s+e)/2;
            boolean canPlace = canPlace(arr, m, mid);
            if(canPlace) {
                ans = Math.max(ans, mid);
                s = mid+1;
            } else {
                e = mid-1;
            }

        } 
        return ans;
    }
    private boolean canPlace(int[] arr, int m, int k) {
        int last = arr[0];
        int count = 1;
        for(int i=1; i<arr.length; i++) {
            if((arr[i] - last) >= k) {
                last = arr[i];
                count++;
                if(count == m) {
                    return true;
                }
            }
        }
        return false;
    }
}