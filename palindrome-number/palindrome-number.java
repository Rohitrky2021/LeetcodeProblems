class Solution {
    public boolean isPalindrome(int x) {
                    String op=String.valueOf(x);
            int m=op.length();
            // String po=op.
            for (int i = 0; i <m ; i++) {
                if(op.charAt(i)!=op.charAt(m-1-i)){
                    return false;
                }
            }
                return true;

    }
}