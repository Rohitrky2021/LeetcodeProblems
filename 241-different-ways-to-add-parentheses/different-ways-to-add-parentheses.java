 

class Solution1 {
    private boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*');
    }

    private List<Integer> getDiffWays(int i, int j, String expression) {
        int len = j - i + 1;
        List<Integer> res = new ArrayList<>();

        // If length of the substring is 1 or 2
        // we encounter our base case i.e. a number found.
        if (len <= 2) {
            res.add(Integer.parseInt(expression.substring(i, i + len)));
            return res;
        }

        // If it is not a number then it is an expression
        // now we try to evaluate every opertor present in it
        for (int ind = i; ind <= j; ind++) {
            if (isOperator(expression.charAt(ind))) {
                char op = expression.charAt(ind);

                // if char at ind is operator 
                // get all results for its left and right substring using recursion
                List<Integer> left = getDiffWays(i, ind - 1, expression);
                List<Integer> right = getDiffWays(ind + 1, j, expression);

                // try all options for left & right operand
                // and push all results to the answer
                for (int l : left) {
                    for (int r : right) {
                        if (op == '+') {
                            res.add(l + r);
                        } else if (op == '-') {
                            res.add(l - r);
                        } else if (op == '*') {
                            res.add(l * r);
                        }
                    }
                }
            }
        }
        return res;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        return getDiffWays(0, n - 1, expression);
    }
}

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                String a = input.substring(0, i);
                String b = input.substring(i + 1);
                List<Integer> al = diffWaysToCompute(a);
                List<Integer> bl = diffWaysToCompute(b);
                for (int x : al) {
                    for (int y : bl) {
                        if (c == '-') {
                            res.add(x - y);
                        } else if (c == '+') {
                            res.add(x + y);
                        } else if (c == '*') {
                            res.add(x * y);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        return res;
    }
}