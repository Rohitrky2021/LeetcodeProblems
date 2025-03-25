import java.util.Stack;

class Solution1 {
    public String removeOuterParentheses(String s) {
        String ans = "";
        char[] arr = s.toCharArray();
        int n = s.length();

        Stack<Character> s1 = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (arr[i] == '(') {
                if (!s1.isEmpty()) sb.append(arr[i]); // Ignore outer '('
                s1.push(arr[i]);
            } else {
                s1.pop();
                if (!s1.isEmpty()) sb.append(arr[i]); // Ignore outer ')'
            }
        }

        return sb.toString();
    }
}


class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int open = 0; // Track depth of parentheses

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (open > 0) ans.append(c); // Ignore outermost '('
                open++;
            } else {
                open--;
                if (open > 0) ans.append(c); // Ignore outermost ')'
            }
        }

        return ans.toString();
    }
}
