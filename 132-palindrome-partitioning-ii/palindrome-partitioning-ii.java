import java.util.ArrayList;
import java.util.List;

class Solution {

    public int minCut(String s) {
        if (s.length() == 0 || isPalindrome(s, 0, s.length() - 1)) return 0;
        
        int n = s.length();
        int[] cuts = new int[n];
        boolean[][] palindrome = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            int minCut = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (j + 1 > i - 1 || palindrome[j + 1][i - 1])) {
                    palindrome[j][i] = true;
                    minCut = (j == 0) ? 0 : Math.min(minCut, cuts[j - 1] + 1);
                }
            }
            cuts[i] = minCut;
        }
        
        return cuts[n - 1];
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
