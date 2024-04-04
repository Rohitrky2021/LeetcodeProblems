class Solution {
  public int maxDepth(String s) {
        char[] ch = s.toCharArray();
        int ans = 0;
        int max = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                max++;
                ans = Math.max(ans, max);
            } else if (ch[i] == ')') {
                max--;
            }
        }
        return ans;
    }
}