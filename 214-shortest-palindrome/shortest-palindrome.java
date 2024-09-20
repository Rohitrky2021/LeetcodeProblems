class Solution1 {
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

// M2 Using KMP ||  LPS algo 
class Solution {
    
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        // Step 1: Reverse the original string
        String rev = new StringBuilder(s).reverse().toString();
        
        // Step 2: Concatenate the original string, a separator, and the reversed string
        String concatenated = s + "#" + rev;
        
        // Step 3: Compute the LPS array for the concatenated string
        int[] lps = computeLPSArray(concatenated);
        
        // Step 4: The last value in the LPS array gives the length of the longest palindrome prefix
        int longestPalindromeLength = lps[lps.length - 1];
        
        // Step 5: Append the reversed non-palindromic part of the original string
        String suffixToAppend = rev.substring(0, s.length() - longestPalindromeLength);
        
        // Return the shortest palindrome
        return suffixToAppend + s;
    }
    
    // Method to compute the LPS array (same as in KMP algorithm)
    private int[] computeLPSArray(String pattern) {
        int M = pattern.length();
        int[] lps = new int[M];
        int len = 0;  // length of the previous longest prefix suffix
        int i = 1;
        
        lps[0] = 0;  // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {  // mismatch after len matches
                if (len != 0) {
                    len = lps[len - 1];  // fall back to previous longest prefix suffix
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

 
}
