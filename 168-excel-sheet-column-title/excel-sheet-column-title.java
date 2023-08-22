// class Solution {
//     public String convertToTitle(int n) {
//         StringBuilder result = new StringBuilder(); // StringBuilder for efficient string concatenation

//         while (n > 0) {
//             n--; // Decrement n by 1 to make the range 0-25 instead of 1-26
//             char currChar = (char) ('A' + n % 26); // Calculate the current character
//             result.insert(0, currChar); // Insert the current character at the beginning of the result string
//             n /= 26; // Move to the next position
//         }

//         return result.toString();
//     }
// }

class Solution {

    public String convertToTitle(int n) {
        String ans="";
        while (n > 0) {
            int curr = (n - 1) % 26;
            char i = (char) ('A' + curr);
           ans = i + ans;
            System.out.println(i);
            n--;//check it ones by Commenting out 
            n /= 26; 
        }

        return ans;
    }
}
// String ans = "";                 // Initialize the result string
// while (n > 0) {
//     int curr = (n - 1) % 26;     // Calculate the remainder to determine the current character position
//     char i = (char) ('A' + curr); // Calculate the character using the adjusted position
//     ans = i + ans;               // Prepend the calculated character to the result string
//     System.out.println(i);       // Print the calculated character
//     n /= 26;                     // Move to the next position
// }
// return ans;                      // Return the final result string
