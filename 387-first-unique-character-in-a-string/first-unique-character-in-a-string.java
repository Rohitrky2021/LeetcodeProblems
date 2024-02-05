class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int i=0;
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
          if(count[c-'a']<2) return i;
          i++;
        }

        return (i==s.length())?-1:i;

    }
}



public class MinIndexOfChars {

    // Function to find the minimum index of the first occurrence of each character from 'a' to 'z' in a given string
    public static int findMinIndexOfChars(String s) {
        // Initialize the answer to the maximum possible value
        int ans = Integer.MAX_VALUE;
        int index;

        // Loop over each character from 'a' to 'z'
        for (char i = 'a'; i <= 'z'; i++) {
            // Find the index of the current character in the string
            index = s.indexOf(i);

            // Check if the character is present in the string and occurs only once
            if ((index != -1) && index == s.lastIndexOf(i)) {
                // Update the answer with the minimum index found so far
                ans = Math.min(ans, index);
            }
        }

        // Return the minimum index found, or -1 if no valid character was found in the string
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    // Main method to test the findMinIndexOfChars function
    public static void main(String[] args) {
        // Example string
        String s = "aabbcd";

        // Call the function and print the result
        int result = findMinIndexOfChars(s);
        System.out.println("Minimum index of the first occurrence for each character: " + result);
    }
}
