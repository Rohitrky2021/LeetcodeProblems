import java.util.HashMap;

class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26]; // Frequencies of characters in 's'
        StringBuilder ans = new StringBuilder(""); // Fixed StringBuilder declaration

        HashMap<Character, Integer> hs = new HashMap<>();

        for (char x : s.toCharArray()) {
            if (hs.containsKey(x)) {
                hs.put(x, hs.get(x) + 1); // Incrementing the count for existing character
            } else {
                hs.put(x, 1); // Adding new character to the HashMap
            }
        }
        
        // Storing frequencies in freq array
        for (char x : s.toCharArray()) {
            freq[x - 'a'] = hs.get(x);
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
        for (char key : hs.keySet()) {
            while (freq[key - 'a'] > 0) {
                sortedString.append(key);
                freq[key - 'a']--; // Decreasing the frequency after appending
            }
        }

        return sortedString.toString();
    }
}
