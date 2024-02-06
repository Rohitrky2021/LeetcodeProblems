class Solution1 {
    public int shipWithinDays(int[] weights, int days) {
        int ans = 0;

        int l = 0;
        int r = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (possible(weights, mid, days)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    static boolean possible(int[] arr, int mid, int days) {
        int n = arr.length;
        int weight = 0;
        int day = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] > mid)
                return false;

            weight += arr[i];
            if (weight > mid) {
                day++;
                weight = arr[i];
            }

            if (day > days)
                return false;
        }

        return true;
    }
}


 

class Solution {
    private boolean check(int[] w, int weightCapacity, int days) {
        int sum = 0;
        int noOfDays = 1;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            if (sum > weightCapacity) {
                noOfDays++;
                sum = w[i];
            }
        }
        if (noOfDays <= days) return true;
        return false;
    }

    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        if (days == 1) return sum;
        if (days >= weights.length) {
            int maxWeight = Arrays.stream(weights).max().getAsInt();
            return maxWeight;
        }

        int s = Arrays.stream(weights).max().getAsInt();
        int e = sum;
        int mid;
        int ans = e;
        while (s <= e) {
            mid = s + (e - s) / 2;
            if (check(weights, mid, days)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }
}
