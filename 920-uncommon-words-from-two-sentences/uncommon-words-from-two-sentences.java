import java.util.HashSet;
import java.util.Set;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Two hash sets to track unique and duplicate words
        Set<String> uniqueWords = new HashSet<>();
        Set<String> duplicateWords = new HashSet<>();
        
        // Split both sentences into words
        String[] st1 = s1.split(" ");
        String[] st2 = s2.split(" ");
        
        // Process words from the first sentence
        for (String word : st1) {
            if (!uniqueWords.add(word)) {
                duplicateWords.add(word); // Move to duplicates if it's already in unique
            }
        }

        // Process words from the second sentence
        for (String word : st2) {
            if (!uniqueWords.add(word)) {
                duplicateWords.add(word); // Move to duplicates if already in unique
            }
        }
        
        // Remove all words that are duplicates
        uniqueWords.removeAll(duplicateWords);
        
        // Convert the set of unique words to a String array
        String[] ans = uniqueWords.toArray(new String[0]);
        
        return ans;
    }
}
