class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(0, n, ans, 0, "");
        return ans;
    }

    public List<String> helper(int close, int n, List<String> ans, int open, String s) {
        if (open == n && close == n) {
            ans.add(s);
            return ans;
        }

        if (open < n) helper(close, n, ans, open + 1, s + "(");

        if (close < open) helper(close + 1, n, ans, open, s + ")");

        return ans;
    }
}
