class Solution {
    public String shortestPalindrome(String s) {
         // Step 1: Reverse the string
        String rev = new StringBuilder(s).reverse().toString();
        
        // Step 2: Find the longest palindrome that starts at the beginning of `s`
        // We check by comparing prefixes of `s` and suffixes of the reversed string
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // Check if the prefix of `s` matches the suffix of `rev`
            if (s.substring(0, n - i).equals(rev.substring(i))) {
                // Step 3: Append the non-palindrome part of the reverse string to the front
                return rev.substring(0, i) + s;
            }
        }
        
        return "";
    }
}
