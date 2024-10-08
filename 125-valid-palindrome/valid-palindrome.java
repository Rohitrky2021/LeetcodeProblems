// class Solution {
//    public boolean isPalindrome(String xyx) {
        
//         xyx= xyx.toLowerCase();
//         xyx= xyx.replaceAll("[^a-z]", "");
//         //   xyx= xyx.replaceAll("[^A-Z]", "");
//         int n=xyx.length();
//         for (int i = 0; i < n/2; i++) {
//             if(Character.toLowerCase(xyx.charAt(i))!=Character.toLowerCase(xyx.charAt(n-1-i))){
//                 return false;
//             }
//         }
        
//         return true;
//     }
// }

// class Solution {
//     public boolean isPalindrome(String xyx) {
//         int n = xyx.length();
//         xyx = xyx.toLowerCase();
//         xyx = xyx.replaceAll("[^a-zA-Z0-9]", "");
//         // if(n!=xyx.length() && xyx.length()==1)return false;
//           n = xyx.length();
          
//         for (int i = 0; i < n / 2; i++) {
//             if (xyx.charAt(i) != xyx.charAt(n - 1 - i)) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }


// class Solution {
//     public boolean isPalindrome(String xyx) {
//         int n = xyx.length();
//         xyx = xyx.toLowerCase();

//         StringBuilder cleanString = new StringBuilder();
        
//         for (int i = 0; i < n; i++) {
//             char c = xyx.charAt(i);
//             if (Character.isLetterOrDigit(c)) {
//                 cleanString.append(c);
//             }
//         }

//         n = cleanString.length();

//         for (int i = 0; i < n / 2; i++) {
//             if (cleanString.charAt(i) != cleanString.charAt(n - 1 - i)) {
//                 return false;
//             }
//         }
        
//         return true;
//     }
// }

class Solution {
    public boolean isPalindrome(String xyx) {
        int n = xyx.length();
        xyx = xyx.toLowerCase();
        
        char[] cleanChars = new char[n];
        int cleanLength = 0;
        
        for (int i = 0; i < n; i++) {
            char c = xyx.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                cleanChars[cleanLength++] = c;
            }
        }

        for (int i = 0; i < cleanLength / 2; i++) {
            if (cleanChars[i] != cleanChars[cleanLength - 1 - i]) {
                return false;
            }
        }

        return true;
    }
}
