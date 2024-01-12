class Solution2 {
    public boolean halvesAreAlike(String s) {
        // String s = sc.nextLine();
        boolean a = false;
        s = s.toLowerCase();
        int count = 0;

        // Count vowels in the second half of the string
        for (int i = s.length() / 2; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o'
                    || currentChar == 'u') {
                count++;
            }
        }

        // Subtract vowels in the first half of the string
        for (int i = 0; i < s.length() / 2; i++) {
            char currentChar = s.charAt(i);

            if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o'
                    || currentChar == 'u') {
                count--;
            }
        }

        return count == 0;

    }
}


class Solution {
    public boolean halvesAreAlike(String s) {
        char[] charArray = s.toLowerCase().toCharArray();
        int count = 0;

        // Count vowels in the second half of the char array
        for (int i = charArray.length / 2; i < charArray.length; i++) {
            char currentChar = charArray[i];

            if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u') {
                count++;
            }
        }

        // Subtract vowels in the first half of the char array
        for (int i = 0; i < charArray.length / 2; i++) {
            char currentChar = charArray[i];

            if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u') {
                count--;
            }
        }

        return count == 0;
    }
}
