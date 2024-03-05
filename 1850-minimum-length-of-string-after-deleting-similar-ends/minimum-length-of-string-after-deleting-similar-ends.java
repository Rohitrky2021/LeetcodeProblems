class Solution1 {
    public int minimumLength(String si) {
        int n = si.length(); // Corrected variable name from s.length to si.length
        char[] s = si.toCharArray();

        int lasti = n - 1;
        int starti = 0;

        // Arrays to store the lengths of prefixes and suffixes
        int[] pre = new int[n];
        int[] suff = new int[n];

        // Calculating the lengths of prefixes
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int count = 1;
            while (j < n && s[j] == s[j - 1]) {
                count++;
                j++;
            }
            pre[i] = count;
            i = j - 1;
        }

        // Calculating the lengths of suffixes
        for (int i = n - 1; i >= 0; i--) {
            int j = i - 1;
            int count = 1;
            while (j >= 0 && s[j] == s[j + 1]) {
                count++;
                j--;
            }
            suff[i] = count;
            i = j + 1;
        }

        // Delete similar ends until the ends differ or they meet in the middle
        while (starti < lasti && s[starti] == s[lasti]) {
            char c = s[starti];

            // Store the previous positions
            int prevStarti = starti;
            int prevLasti = lasti;

            // Delete consecutive occurrences of c from prefix
            starti += pre[starti];

            // Delete consecutive occurrences of c from suffix
            lasti -= suff[lasti];

            // If starti > lasti, reverse the last change
            if (starti > lasti) {
                starti = prevStarti;
                lasti = prevLasti;
                break; // Exit the loop
            }
        }
                System.out.println(starti+" "+lasti);


            if(s[starti] == s[lasti] && starti!=lasti)return 0;
        // Return the number of remaining characters
        return lasti - starti + 1;
    }
}


public class Solution {
    public int minimumLength(String s) {
        int begin = 0;
        int end = s.length() - 1;

        // Delete similar ends until the ends differ or they meet in the middle
        while (begin < end && s.charAt(begin) == s.charAt(end)) {
            char c = s.charAt(begin);

            // Delete consecutive occurrences of c from prefix
            while (begin <= end && s.charAt(begin) == c) {
                begin++;
            }

            // Delete consecutive occurrences of c from suffix
            while (end > begin && s.charAt(end) == c) {
                end--;
            }
        }

        // Return the number of remaining characters
        return end - begin + 1;
    }
}