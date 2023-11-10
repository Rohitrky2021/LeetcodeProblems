public class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder();

        int openCount = 0;
        int closeCount = 0;

        // Iterate from left to right and remove unnecessary closing parentheses
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                openCount++;
            } else if (ch == ')') {
                if (openCount > 0) {
                    openCount--;
                } else {
                    continue; // Skip unnecessary closing parentheses
                }
            }
            result.append(ch);
        }

        // Clear the StringBuilder and reset counts for the second iteration
        StringBuilder finalResult = new StringBuilder();
        openCount = 0;

        // Iterate from right to left and remove unnecessary opening parentheses
        for (int i = result.length() - 1; i >= 0; i--) {
            char ch = result.charAt(i);
            if (ch == ')') {
                openCount++;
            } else if (ch == '(') {
                if (openCount > 0) {
                    openCount--;
                } else {
                    continue; // Skip unnecessary opening parentheses
                }
            }
            finalResult.insert(0, ch);
        }

        return finalResult.toString();
    }
}
