import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (len == k) return "0"; // if all digits need to be removed, return "0"
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < len; i++) {
            char currentDigit = num.charAt(i);
            
            // while there are digits in the stack and currentDigit is less than the top digit
            while (!stack.isEmpty() && k > 0 && currentDigit < stack.peek()) {
                stack.pop(); // remove the top digit
                k--; // decrement k since a digit is removed
            }
            
            stack.push(currentDigit); // add currentDigit to the stack
        }
        
        // if there are still digits to be removed, remove them from the end of the stack
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        
        // construct the result string
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop()); // prepend each digit from the stack to ans
        }
        
        // remove leading zeroes
        while (ans.length() > 1 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }
        
        return ans.toString();
    }
}


class Solution2 {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (len == k) // If the number of digits to be removed is the same as the length of the number, return "0"
            return "0";

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < len; i++) {
            char currentDigit = num.charAt(i);

            // While k is still positive and the last digit in the ans is greater than the current digit
            while (k > 0 && ans.length() > 0 && ans.charAt(ans.length() - 1) > currentDigit) {
                ans.deleteCharAt(ans.length() - 1); // Remove the last digit from ans
                k--; // Decrement k as we removed a digit
            }

            ans.append(currentDigit); // Append the current digit to ans
        }

        // If after the main loop, there are still digits to be removed (k > 0), remove them from the end
        while (k > 0 && ans.length() > 0) {
            ans.deleteCharAt(ans.length() - 1);
            k--;
        }

        // Trim leading zeros
        int nonZeroStart = 0;
        while (nonZeroStart < ans.length() && ans.charAt(nonZeroStart) == '0') {
            nonZeroStart++;
        }

        // If all the digits are removed, return "0", otherwise return the result
        return ans.length() == nonZeroStart ? "0" : ans.substring(nonZeroStart);
    }
}
