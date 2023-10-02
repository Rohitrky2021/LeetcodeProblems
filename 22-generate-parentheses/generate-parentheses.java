// class Solution {

//     public List<String> generateParenthesis(int n) {
//         List<String> ans = new ArrayList<>();
//         helper(0, n, ans, 0, "");
//         return ans;
//     }

//     public List<String> helper(int close, int n, List<String> ans, int open, String s) {
//         if (open == n && close == n) {
//             ans.add(s);
//             return ans;
//         }

//         if (open < n) helper(close, n, ans, open + 1, s + "(");

//         if (close < open) helper(close + 1, n, ans, open, s + ")"); // If condition is important here

//         return ans;
//     }
// }
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesisDP(n, n, "", ans, new StringBuilder());
        return ans;
    }

    public void generateParenthesisDP(int open, int close, String current, List<String> ans, StringBuilder temp) {
        if (open == 0 && close == 0) {
            ans.add(current);
            return;
        }

        if (open > 0) {
            temp.append('(');
            generateParenthesisDP(open - 1, close, current + '(', ans, temp);
            temp.deleteCharAt(temp.length() - 1);
        }

        if (close > open) {
            temp.append(')');
            generateParenthesisDP(open, close - 1, current + ')', ans, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
