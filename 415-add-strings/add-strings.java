import java.util.*;

class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += num2.charAt(j--) - '0';
            }

            carry = sum / 10;
            result.insert(0, sum % 10);
        }

        return result.toString();
    }
}
