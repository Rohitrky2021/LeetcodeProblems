class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        isPrime(right+1);
        for (int i = left; i <= right; i++) {
            if (isPrimeSetBits(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean isPrimeSetBits(int num) {
        int bitCount = Integer.bitCount(num);
        return bitCount > 1 && ck[bitCount];
    }
    public boolean ck[];

    public void isPrime(int high) {
        // boolean ans[]=new boolean[high + 1];
        ck = new boolean[high + 1];
        Arrays.fill(ck, true);
        ck[1] = false;
        ck[0] = false;

        for (int i = 2; (i * i) <= high; i++) {
            if (ck[i] == true) {
                for (int j = i * i; j <= Math.sqrt(high); j = j + i) {// Stroring in Ck[] --> SqrtN
                    ck[j] = false;
                }
            }
        }
        // for (int i = 2; i * i <= high; i++) {
        //     if (ck[i] == true) {
        //         // cout<< i<<"\n";
        //        ans[i-2]=true;
        //     }
        // }
    }
}
