import java.util.Stack;

class Solution {
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
