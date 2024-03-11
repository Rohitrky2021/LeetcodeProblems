import java.util.Arrays;

class Solution {
    public String customSortString(String order, String s) {
        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
    
        for (char ch : order.toCharArray()) {
            while (arr[ch - 'a'] != 0) {
                sb.append(ch);
                arr[ch - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            while (arr[i] != 0) {
                sb.append((char)(i + 'a'));
                arr[i]--;
            }
        }

        return sb.toString();
    }
}
