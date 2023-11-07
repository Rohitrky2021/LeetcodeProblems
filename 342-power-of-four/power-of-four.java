class Solution {
    public boolean isPowerOfFour(int n) {
        return isPowerOfTwo(n)&& n%3==1;
    }
        public boolean isPowerOfTwo(int n) {
        if(n==0 || n<0)return false;
        return  ( n &(n-1)) ==0?true:false;
    }
}