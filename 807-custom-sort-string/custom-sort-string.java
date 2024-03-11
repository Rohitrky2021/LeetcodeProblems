import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26]; // Frequencies of characters in 's'
        StringBuilder ans = new StringBuilder(""); // Fixed StringBuilder declaration

        HashSet<Character> hs = new HashSet<>(); // Changed to HashSet

        for (char x : s.toCharArray()) {
            if (hs.contains(x)) {
                freq[x - 'a']++;
            } else {
                freq[x - 'a'] = 1;
                hs.add(x); // Adding new character to the HashSet
            }
        }

        // Here's a simple approach to get sorted characters
        StringBuilder sortedString = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (freq[c - 'a'] > 0) {
                sortedString.append(c);
                freq[c - 'a']--; // Decreasing the frequency after appending
            }
        }

        // Append the remaining characters (if any) from s which are not present in the custom order
        for (char key : hs) {
            while (freq[key - 'a'] > 0) {
                sortedString.append(key);
                freq[key - 'a']--; // Decreasing the frequency after appending
            }
        }

        return sortedString.toString();
    }
}
