class Solution {
    public String minWindow(String s1, String s2) {
     // Initialize an empty string to store the result
        String result = "";
        
        // Create a HashMap to store the frequency of characters in string s2
        HashMap<Character, Integer> targetMap = new HashMap<>();
        for (char ch : s2.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }
        
        // Initialize pointers for the sliding window
        int left = 0;
        int right = 0;
        int matchCount = 0;
        int requiredMatches = s2.length();
        HashMap<Character, Integer> windowMap = new HashMap<>();
        
        while (right < s1.length()) {
            char currentChar = s1.charAt(right);
            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);
            
            if (windowMap.get(currentChar) <= targetMap.getOrDefault(currentChar, 0)) {
                matchCount++;
            }
            
            // Try to minimize the window by moving the left pointer
            while (matchCount == requiredMatches) {
                String currentWindow = s1.substring(left, right + 1);
                
                // Update the result if it's empty or the current window is smaller
                if (result.isEmpty() || currentWindow.length() < result.length()) {
                    result = currentWindow;
                }
                
                char leftChar = s1.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                
                if (windowMap.get(leftChar) < targetMap.getOrDefault(leftChar, 0)) {
                    matchCount--;
                }
                
                left++;
            }
            
            right++;
        }
        
        return result;
    }
}