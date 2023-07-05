class Solution {
    public int trailingZeroes(int n) {
        return countTrailingZeroes(n);
    }
    public static int countTrailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            n = n / 5;
            count += n;
        }
        return count;
    }
}