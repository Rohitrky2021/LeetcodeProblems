import java.util.Arrays;

// Brute Force 
class Solution1 {
    public String longestPalindrome(String s) {
        for (int length = s.length(); length > 0; length--) {
            for (int start = 0; start <= s.length() - length; start++) {
                if (check(start, start + length, s)) {
                    return s.substring(start, start + length);
                }
            }
        }
        
        return "";
    }
    
    private boolean check(int i, int j, String s) {
        int left = i;
        int right = j - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
}

// Using Dp 
class Solution2 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] ans = new int[]{0, 0};
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                ans[0] = i;
                ans[1] = i + 1;
            }
        }
        
        for (int diff = 2; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        
        int i = ans[0];
        int j = ans[1];
        return s.substring(i, j + 1);
    }
}

class Manacher {
    String t;
    int[] p;
    int lpsStart, lpsLength;

    public Manacher(String s) {
        for (char c : s.toCharArray()) {
            t += "#" + c;
        }
        t += "#";

        build();
    }

    void build() {
        int n = t.length();
        p = new int[n];
        Arrays.fill(p, 1);

        int l = 1, r = 1;

        for (int i = 1; i < n; i++) {
            if (l + r - i >= 0)
                p[i] = Math.max(1, Math.min(r - i, p[l + r - i]));

            while (i - p[i] >= 0 && i + p[i] < n && t.charAt(i - p[i]) == t.charAt(i + p[i]))
                p[i]++;

            if (i + p[i] > r) {
                l = i - p[i];
                r = i + p[i];

                if (lpsLength < p[i]) {
                    lpsStart = l + 2;
                    lpsLength = p[i] - 1;
                }
            }
        }
    }

    int getLongest(int center, boolean odd) {
        int position = 2 * center + 1 + (odd ? 1 : 0);
        return p[position] - 1;
    }

    boolean checkPalindrome(int l, int r) {
        if ((r - l + 1) <= getLongest((l + r) / 2, (r - l + 1) == 1))
            return true;
        return false;
    }

    String longestPalindromeSubstring() {
        int n = t.length();
        StringBuilder ans = new StringBuilder();
        for (int i = lpsStart; i < n && lpsLength-- > 0; i += 2) {
            ans.append(t.charAt(i));
        }
        return ans.toString();
    }
}

class Solution {
    public String longestPalindrome(String s) {
        Manacher m = new Manacher(s);
        return m.longestPalindromeSubstring();
    }
}
