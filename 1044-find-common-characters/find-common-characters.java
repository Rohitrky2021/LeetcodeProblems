import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] words) {
        int[] freq = new int[128];
        
        // Initialize freq array with occurrences of characters in the first word
        for (char x : words[0].toCharArray()) {
            freq[x]++;
        }

        // Iterate through the rest of the words
        for (int i = 1; i < words.length; i++) {
            int[] tempFreq = new int[128];
            for (char x : words[i].toCharArray()) {
                tempFreq[x]++;
            }
            // Update freq array to hold minimum occurrences of each character
            for (int j = 0; j < 128; j++) {
                freq[j] = Math.min(freq[j], tempFreq[j]);
            }
        }

        List<String> ans = new ArrayList<>();

        // Convert the occurrences to actual characters and add them to the result list
        for (int i = 0; i < 128; i++) {
            for (int j = 0; j < freq[i]; j++) {
                ans.add(String.valueOf((char) i));
            }
        }
        return ans;
    }
}
