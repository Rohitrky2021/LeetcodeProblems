class Solution {
public String fractionAddition(String expression) {
        List<Integer> denom = new ArrayList<>();
        List<Integer> num = new ArrayList<>();
        List<Character> sign = new ArrayList<>();

        int i = 0;
        int n = expression.length();

        // Add a '+' at the start if the expression doesn't start with '+' or '-'
        if (expression.charAt(0) != '-' && expression.charAt(0) != '+') {
            expression = "+" + expression;
            n++;
        }

        while (i < n) {
            // Parse the sign
            char currentSign = expression.charAt(i++);
            sign.add(currentSign);

            // Parse the numerator
            int numerator = 0;
            boolean negative = false;
            if (currentSign == '-') {
                negative = true;
            }

            while (i < n && Character.isDigit(expression.charAt(i))) {
                numerator = numerator * 10 + (expression.charAt(i) - '0');
                i++;
            }

            if (negative) {
                numerator = -numerator;
            }
            num.add(numerator);

            // Skip the '/'
            i++;

            // Parse the denominator
            int denominator = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                denominator = denominator * 10 + (expression.charAt(i) - '0');
                i++;
            }
            denom.add(denominator);
        }

        // Find the LCM of denominators
        int lcm = findLCM(denom);

        int curr = 0;

        for (int j = 0; j < denom.size(); j++) {
            int multi = lcm / denom.get(j);
            curr += multi * num.get(j);
        }

        return convertDecimalToFraction(curr, lcm);
    }

    // Function to find LCM of a list of numbers
    private int findLCM(List<Integer> denom) {
        int lcm = denom.get(0);
        for (int i = 1; i < denom.size(); i++) {
            lcm = lcm(lcm, denom.get(i));
        }
        return lcm;
    }

    // Helper function to calculate LCM
    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // Helper function to calculate GCD
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Function to convert the result into a fraction
    private String convertDecimalToFraction(int numerator, int denominator) {
        int gcd = gcd(Math.abs(numerator), denominator);
        numerator /= gcd;
        denominator /= gcd;
        return numerator + "/" + denominator;
    }




}