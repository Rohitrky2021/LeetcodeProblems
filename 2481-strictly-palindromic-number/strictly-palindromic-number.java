class Solution1 {
    public boolean isStrictlyPalindromic(int n) {
        
        return false;
    }
}

class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for (int base = 2; base < n - 1; base++) {
            if (!isPalindrom(Integer.toString(n, base))) {
                return false;
            }  
        }
        return true;
    }
    private final boolean isPalindrom(String string) {
        int size = string.length();
        for (int index = 0; index < size; index++) {
            if (string.charAt(index) != string.charAt(size - index - 1)) {
                return false;
            }
        }
        return true;
    }
}