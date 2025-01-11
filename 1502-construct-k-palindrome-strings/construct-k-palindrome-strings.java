import java.util.HashMap;

class Solution {
    public boolean canConstruct(String s, int k) {
        if (k > s.length()) {
            return false; // Impossible to create more palindromes than the length of the string
        }
        
        // Count frequency of each character
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        // Count the number of characters with odd frequencies
        int oddCount = 0;
        for (int count : freq.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }
        
        // Check if the number of odd characters is less than or equal to k
        return oddCount <= k;
    }
}
