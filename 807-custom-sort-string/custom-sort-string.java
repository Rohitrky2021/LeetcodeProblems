import java.util.Arrays;

class Solution1 {
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

class Solution {
    public String customSortString(String order, String s) {
        // Create char array for editing
        int N = s.length();
        Character[] result = new Character[N];
        for (int i = 0; i < N; i++) {
            result[i] = s.charAt(i);
        }

        // Define the custom comparator
        Arrays.sort(result, (c1, c2) -> {
            // The index of the character in order determines the value to be sorted by
            return order.indexOf(c1) - order.indexOf(c2);
        });

        // Return the result
        String resultString = "";
        for (Character c: result) {
            resultString += c;
        }
        return resultString;
    }
}