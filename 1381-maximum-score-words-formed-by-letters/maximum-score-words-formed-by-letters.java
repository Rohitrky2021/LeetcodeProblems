import java.util.*;

class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int maxScore = 0;
        int[] letterFreq = new int[26];
        
        // Count the frequency of each letter in the letters array
        for (char letter : letters) {
            letterFreq[letter - 'a']++;
        }
        
        // Generate all possible subsets of words
        for (int i = 0; i < (1 << words.length); i++) {
            int[] subsetLetterFreq = Arrays.copyOf(letterFreq, letterFreq.length);
            int subsetScore = 0;
            boolean validSubset = true;
            
            // Check if the current subset of words can be formed using the given letters
            for (int j = 0; j < words.length; j++) {
                if ((i & (1 << j)) > 0) { // Check if jth word is in the subset
                    String word = words[j];
                    for (char c : word.toCharArray()) {
                        int index = c - 'a';
                        subsetLetterFreq[index]--;
                        if (subsetLetterFreq[index] < 0) {
                            validSubset = false;
                            break;
                        }
                        subsetScore += score[index];
                    }
                    if (!validSubset) break;
                }
            }
            
            // Update maxScore if the current subset is valid and its score is greater than maxScore
            if (validSubset && subsetScore > maxScore) {
                maxScore = subsetScore;
            }
        }
        
        return maxScore;
    }
}
