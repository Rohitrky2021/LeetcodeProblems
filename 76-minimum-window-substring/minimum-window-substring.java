class Solution {
    public String minWindow(String s1, String s2) {
      String result = "";
        
        // Character array to store frequency counts
        int[] targetMap = new int[256]; // Assuming extended ASCII
        
        // Fill the target map with frequencies of characters in s2
        for (char ch : s2.toCharArray()) {
            targetMap[ch]++;
        }
        
        int left = 0;
        int right = 0;
        int matchCount = 0;
        int requiredMatches = s2.length();
        int[] windowMap = new int[256];
        
        while (right < s1.length()) {
            char currentChar = s1.charAt(right);
            windowMap[currentChar]++;
            
            if (windowMap[currentChar] <= targetMap[currentChar]) {
                matchCount++;
            }
            
            while (matchCount == requiredMatches) {
                // Update the result if it's empty or the current window is smaller
                if (result.isEmpty() || (right - left + 1) < result.length()) {
                    result = s1.substring(left, right + 1);
                }
                
                char leftChar = s1.charAt(left);
                windowMap[leftChar]--;
                
                if (windowMap[leftChar] < targetMap[leftChar]) {
                    matchCount--;
                }
                
                left++;
            }
            
            right++;
        }
        
        return result;
    }
}



// M2 
