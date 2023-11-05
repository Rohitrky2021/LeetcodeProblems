class Solution1 {

    public int getLastMoment(int n, int[] left, int[] right) {
        Arrays.sort(left);
        Arrays.sort(right);

        if (left.length != 0 && right.length != 0) return Math.max(left[left.length - 1], n - right[0]);

        if (left.length == 0) return n- right[0];
        if (right.length == 0) return left[left.length - 1];

        return -1;
    }
}


class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;
        for (int num : left) {
            ans = Math.max(ans, num);
        }
        
        for (int num : right) {
            ans = Math.max(ans, n - num);
        }
        
        return ans;
    }
}