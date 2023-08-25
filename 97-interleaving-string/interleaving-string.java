public class Solution {

    // public boolean is_Interleave(String s1, int i, String s2, int j, String res, String s3)
    // {
    //     if(res.equals(s3) && i == s1.length() && j == s2.length())
    //         return true;
    //     boolean ans = false;
    //     if(i < s1.length())
    //         ans |= is_Interleave(s1, i + 1, s2, j, res + s1.charAt(i), s3);
    //     if(j < s2.length())
    //         ans |= is_Interleave(s1, i, s2, j + 1, res + s2.charAt(j), s3);
    //     return ans;

    // }
    // public boolean isInterleave(String s1, String s2, String s3) {
    //     if (s1.length() + s2.length() != s3.length()) {
    //         return false;
    //     }
    //     return is_Interleave(s1, 0, s2, 0, "", s3);
    // }

    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) return false;
        return dfs(c1, c2, c3, 0, 0, 0, new boolean[m + 1][n + 1]);
    }

    public boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean[][] invalid) {
        if (invalid[i][j]) return false;
        if (k == c3.length) return true;
        boolean valid = i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i + 1, j, k + 1, invalid) || j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j + 1, k + 1, invalid);
        if (!valid) invalid[i][j] = true;
        return valid;
    }
}
