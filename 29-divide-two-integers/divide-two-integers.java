class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        long ans = (long) dividend / divisor;

        if (ans < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else if (ans > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else
            return (int) ans;
    }
}
