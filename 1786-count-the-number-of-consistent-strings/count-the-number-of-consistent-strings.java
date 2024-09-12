import java.util.HashSet;

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;

        // Store allowed characters in a HashSet for O(1) average lookup time
        HashSet<Character> allowedSet = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            allowedSet.add(c);
        }

        // Check each word
        for (String word : words) {
            boolean isConsistent = true;
            // Check if every character in the word is in the allowed set
            for (char c : word.toCharArray()) {
                if (!allowedSet.contains(c)) {
                    isConsistent = false;
                    break;  // Early exit if any character is not allowed
                }
            }
            if (isConsistent) {
                count++;
            }
        }

        return count;
    }
}
