import java.util.HashMap;

class Solution {
    public String customSortString(String order, String s) {
         
        StringBuilder ans = new StringBuilder(""); // Fixed StringBuilder declaration

        HashMap<Character, Integer> hs = new HashMap<>();

        for (char x : s.toCharArray()) {
            if (hs.containsKey(x)) {
                hs.put(x, hs.get(x) + 1); // Incrementing the count for existing character
            } else {
                hs.put(x, 1); // Adding new character to the HashMap
            }
        }

        // Here's a simple approach to get sorted characters
        StringBuilder sortedString = new StringBuilder();
        for (char c : order.toCharArray()) {
            if (hs.containsKey(c)) {
                while (hs.get(c) > 0) {
                    sortedString.append(c);
                    hs.put(c, hs.get(c) - 1);
                }
                hs.remove(c); // Removing the character after adding to the sorted string
            }
        }

        // Append the remaining characters (if any) from s which are not present in the custom order
        for (char key : hs.keySet()) {
            while (hs.get(key) > 0) {
                sortedString.append(key);
                hs.put(key, hs.get(key) - 1);
            }
        }

        return sortedString.toString();
    }
}
