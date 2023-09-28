// class Solution {

//     public int characterReplacement(String s, int k) {
//         //  Hook ---> Here jiski freq kum hogi unko convert krna h so ---> use h hashing of [26]-alphabets
//         char arr[] = s.toCharArray();
//         int f[]=new int[26];
//         int tail = 0, ans = 0, sum = 0, targetsum = k, head/*makeing it global */;
//         for (head = 0; head < arr.length; head++) {
//             f[ arr[head]-'A']++;
//             char c= Math.min(f[0],f[1])=='A'?'A':'B';
//             if (arr[head] == c) k--;
//             ans = Math.max(ans, head - tail);

//             while (k < f[0] && k<f[1]) {
//                 if (arr[tail] == 'A') k++;
//                 tail++;
//             }

//             ans = Math.max(ans, head - tail + 1);
//         }

//         // return head-tail+1;
//         return ans;
//     }
// }

// class Solution {

//     public int characterReplacement(String s, int k) {
//         char arr[] = s.toCharArray();
//         int f[] = new int[26];
//         int tail = 0, ans = 0, head;

//         for (head = 0; head < arr.length; head++) {
//             f[arr[head] - 'A']++;

//             // Calculate the number of characters to replace in the current window
//             // int replacementsNeeded = ;

//             // If replacementsNeeded is greater than k, move the window's left end (tail) to the right
//             while ((head - tail + 1) - Math.max(f[0], f[1])> k) {
//                 f[arr[tail] - 'A']--;
//                 tail++;
//                 // replacementsNeeded = (head - tail + 1) - Math.max(f[0], f[1]);
//             }

//             ans = Math.max(ans, head - tail + 1);
//         }

//         return ans;
//     }
// }

class Solution {

    public int characterReplacement(String s, int k) {
        char arr[] = s.toCharArray();
        int f[] = new int[26];
        int tail = 0, ans = 0, head,max=0;

        for (head = 0; head < arr.length; head++) {
            f[arr[head]- 'A']++;

              max =  Math.max(max, f[arr[head] - 'A']);

            // Check if the window needs adjustments to make it valid
            while ((head - tail + 1) - max > k) {
                f[arr[tail] - 'A']--; // Decrement the frequency count
                tail++;
            }

            ans = Math.max(ans, head - tail + 1);
        }

        return ans;
    }
}

// // Time Complexity :  O(n)
// // Space Complexity : O(1)
// class Solution {
//     public int characterReplacement(String s, int k) {
//         // Make an array of size 26...
//         int[] arr = new int[26];
//         // Initialize largestCount, maxlen & beg pointer...
//         int largestCount = 0, beg = 0, maxlen = 0;
//         // Traverse all characters through the loop...
//         for(int end = 0; end < s.length(); end ++){
//             arr[s.charAt(end) - 'A']++;
//             // Get the largest count of a single, unique character in the current window...
//             largestCount = Math.max(largestCount, arr[s.charAt(end) - 'A']);
//             // We are allowed to have at most k replacements in the window...
//             // So, if max character frequency + distance between beg and end is greater than k...
//             // this means we have considered changing more than k charactres. So time to shrink window...
//             // Then there are more characters in the window than we can replace, and we need to shrink the window...
//             if(end - beg + 1 - largestCount > k){     // The main equation is: end - beg + 1 - largestCount...
//                 arr[s.charAt(beg) - 'A']--;
//                 beg ++;
//             }
//             // Get the maximum length of repeating character...
//             maxlen = Math.max(maxlen, end - beg + 1);     // end - beg + 1 = size of the current window...
//         }
//         return maxlen;      // Return the maximum length of repeating character...
//     }
// }