class Solution {
    public int scoreOfString(String s) {
        int t = 0, i = 1;
        while (i < s.length()) {
            char c = s.charAt(i);
            char p = s.charAt(i - 1);
            int d = Math.abs(c - p);
            t += d;
            i++;
        }
        return t;
    }
}
