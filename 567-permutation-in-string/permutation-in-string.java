public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int[] freq = new int[26];
        int m = s2.length();
        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i) - 'a']++;
        }
        int[] freq2 = new int[26];
        for (int i = 0; i < m; i++) {
            freq2[s2.charAt(i) - 'a']++;
            if (i >= n) {
                freq2[s2.charAt(i - n) - 'a']--;
            }
            if (Arrays.equals(freq, freq2))
                return true;
        }
        return false;
    }
}

class Solution1 {
    public boolean checkInclusion(String s1, String s2) {
        int k=s1.length();
      // Step 1: Initialize the frequency arrays for s1 and the current window in s2
        int[] f1 = new int[26];
        int[] f2 = new int[26];

        if(k>s2.length())return false;
 


        // Step 2: Populate the frequency array for s1
        for (char c : s1.toCharArray()) {
            int index = c - 'a';
            f1[index]++;
        }

        // Step 3: Iterate through the first window in s2
        for (int i = 0; i < k; i++) {
            char c = s2.charAt(i);
            int index = c - 'a';
            f2[index]++;
        }

        // Step 4: Check if the initial window matches
        if (checkEqualArrays(f1, f2)) {
            return true;
        }

        // Step 5: Slide the window and check for equality in subsequent windows
        for (int i = k; i < s2.length(); i++) {
            char outgoingChar = s2.charAt(i - k);
            char incomingChar = s2.charAt(i);

            // Update the frequency arrays for the sliding window
            f2[outgoingChar - 'a']--;
            f2[incomingChar - 'a']++;

            // Check if the current window matches
            if (checkEqualArrays(f1, f2)) {
                return true;
            }
        }

        // No matching window found
        return false;
    }

    // Helper function to check if two arrays are equal
    private static boolean checkEqualArrays(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}