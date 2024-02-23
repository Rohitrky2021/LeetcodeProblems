class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (isPrimeSetBits(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean isPrimeSetBits(int num) {
        int bitCount = Integer.bitCount(num);
        return bitCount > 1 && isPrime(bitCount);
    }

    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
