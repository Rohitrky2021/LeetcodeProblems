class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] left = new int[26];  // Track characters seen on the left
        int[] right = new int[26]; // Track characters seen on the right

        // Fill the right array with frequencies of all characters
        for (int i = 0; i < n; i++) {
            right[s.charAt(i) - 'a']++;
        }

        HashSet<String> uniquePalindromes = new HashSet<>();

        // Traverse the string
        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);
            right[current - 'a']--; // Reduce count in the right array as the character is now the center

            // Check all characters for potential palindromes
            for (int j = 0; j < 26; j++) {
                if (left[j] > 0 && right[j] > 0) {
                    // Create a palindrome string "aXa" where 'a' = j+'a' and 'X' is the current character
                    String palindrome = "" + (char)(j + 'a') + current + (char)(j + 'a');
                    uniquePalindromes.add(palindrome);
                }
            }

            // Mark current character in the left array
            left[current - 'a']++;
        }

        // Return the count of unique palindromes
        return uniquePalindromes.size();
    }
}
