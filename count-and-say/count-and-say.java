class Solution {

    public static String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }

        String currentTerm = "1"; // Base case

        for (int i = 2; i <= n; i++) {
            StringBuilder nextTerm = new StringBuilder();
            int count = 1;
            char prevDigit = currentTerm.charAt(0);

            for (int j = 1; j < currentTerm.length(); j++) {
                char currentDigit = currentTerm.charAt(j);

                if (currentDigit == prevDigit) {
                    count++;
                } else {
                    nextTerm.append(count).append(prevDigit);
                    count = 1;
                    prevDigit = currentDigit;
                }
            }

            nextTerm.append(count).append(prevDigit);
            currentTerm = nextTerm.toString();
        }

        return currentTerm;
    }
}
