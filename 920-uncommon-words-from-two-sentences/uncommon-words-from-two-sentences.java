import java.util.HashSet;
import java.util.Set;

class Solution1 {
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



class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Use a HashMap to count occurrences of words from both sentences
        HashMap<String, Integer> wordCount = new HashMap<>();
        
        // Split both sentences into words
        String[] st1 = s1.split(" ");
        String[] st2 = s2.split(" ");
        
        // Count occurrences from first sentence
        for (String word : st1) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Count occurrences from second sentence
        for (String word : st2) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Collect the words that appear exactly once
        List<String> result = new ArrayList<>();
        for (String word : wordCount.keySet()) {
            if (wordCount.get(word) == 1) {
                result.add(word);
            }
        }
        
        // Convert the list to an array and return
        return result.toArray(new String[result.size()]);
    }
}
