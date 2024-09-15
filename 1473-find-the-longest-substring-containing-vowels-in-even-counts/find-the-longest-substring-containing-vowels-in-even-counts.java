import java.util.HashMap;

class Solution {
    public int findTheLongestSubstring(String s) {
        char[] sa = s.toCharArray();
        int n = s.length();
        
        // Create a map to track the state of vowels using bits (binary state)
        HashMap<Integer, Integer> stateMap = new HashMap<>();
        stateMap.put(0, -1); // Base case, when no vowels have been encountered
        
        int state = 0; // This will hold the binary state for vowel parity (even or odd)
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            char c = sa[i];
            
            // Update the state when encountering vowels
            if (c == 'a') {
                state ^= (1 << 0);
            } else if (c == 'e') {
                state ^= (1 << 1);
            } else if (c == 'i') {
                state ^= (1 << 2);
            } else if (c == 'o') {
                state ^= (1 << 3);
            } else if (c == 'u') {
                state ^= (1 << 4);
            }
            
            // Check if this state has been seen before
            if (stateMap.containsKey(state)) {
                // Calculate the length of the substring between previous occurrence and now
                maxLen = Math.max(maxLen, i - stateMap.get(state));
            } else {
                // Store the first occurrence of this state
                stateMap.put(state, i);
            }
        }
        
        return maxLen;
    }
}
