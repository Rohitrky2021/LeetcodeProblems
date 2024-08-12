import java.util.*;

class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        // Map to store the order of each character
        Map<Character, Integer> hm = new HashMap<>();
        int i = 0;
        for (char x : order.toCharArray()) {
            hm.put(x, i++);
        }

        // Sort words based on the alien dictionary order
        String[] sortedWords = words.clone();

        Arrays.sort(sortedWords, (a, b) -> {
            int len = Math.min(a.length(), b.length());
            for (int j = 0; j < len; j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    return hm.get(a.charAt(j)) - hm.get(b.charAt(j));
                }
            }
            // If the words are the same up to the length of the shorter one,
            // the shorter word should come first
            return a.length() - b.length();
        });

        // Check if the original array is the same as the sorted one
        return Arrays.equals(words, sortedWords);
    }
}
