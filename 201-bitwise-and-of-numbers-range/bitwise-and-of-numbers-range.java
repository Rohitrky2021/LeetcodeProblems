class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        
        // Find the common leftmost bits of m and n
        while (m < n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }
        
        // Left shift back to obtain the result
        return m << shift;
    }
}
