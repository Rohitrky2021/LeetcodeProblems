import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        Set<Character> characters = new HashSet<>();
        
        while (right < s.length()) {
            if (!characters.contains(s.charAt(right))) {
                characters.add(s.charAt(right));
                maxLength = Math.max(maxLength, characters.size());
                right++;
            } else {
                characters.remove(s.charAt(left));
                left++;
            }
        }
        
        return maxLength;
    }
}
