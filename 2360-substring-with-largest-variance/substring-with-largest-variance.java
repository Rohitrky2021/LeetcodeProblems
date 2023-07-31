class Solution {
    public int largestVariance(String s) {
        
        // First get the count of all characters in the string
        int[] freq = new int[26];
        boolean invalid = true;
        for (int i = 0; i < s.length(); i++) {
            // if the character frequency is never greater than 1
            // then the max variance is always 0. (ab == 0, but aab == 1)
            if (++freq[s.charAt(i) - 'a'] > 1) { 
                invalid = false;
            }
        }
        if (invalid) return 0;
        
        // Next we need to compare the number of occurrences between 
        // every character in the string so the complexity is O(26*26) worst case
        int maxVariance = 0;
        
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) // if freq == 0 then character does not exist 
                continue;
            
            for (int j = 0; j < 26; j++) {
                if (i == j || freq[j] == 0) // if the same as first character or does not exist
                    continue;
                
                // Now we have 2 chars to compare
                // iterate over the string compare the count of the first character i
                // with the second character j and decrease their frequency
                int c1_count = 0, c2_count = 0, c1_freq = freq[i], c2_freq = freq[j];
                for (char c: s.toCharArray()) {
                    int curr = c-'a'; // current character in string
                    
                    if (curr == i) {
                        c1_count++;
                        c1_freq--;
                    }
                    else if (curr == j) {
                        c2_count++;
                        c2_freq--;
                    }
                    else {
                        continue; // neither character increased no action required
                    }
                    
                    // if first character count is less than the second character count
                    // and both characters have atleast one character left in the string
                    // then we reset both counts to try a better substring
                    if (c1_count < c2_count &&  c1_freq > 0 && c2_freq > 0) {
                        c1_count = 0; c2_count = 0;
                    }
                    // if second character count is atleast 1 and first character count is
                    // greater than second character count,
                    // check if variance is greater than maxVariance
                    else if (c2_count > 0 && c1_count > c2_count) {
                        maxVariance = Math.max(maxVariance, c1_count - c2_count);
                    }
                    // if both character frequency is 0 then no more variances in string
                    // for the current two characters, so we break out of the loop
                    else if (c1_freq+c2_freq == 0)
                        break;
                }
            }
        }
        return maxVariance;
    }
}

// class Solution {
//     public int largestVariance(String s) {
//         int output = 0;
//         int[][] dif = new int[26][26];
//         int[][] difB = new int [26][26];
//         for(int i = 0; i < 26; i++){
//             Arrays.fill(difB[i], -s.length());
//         }

//         for(int j = 0; j < s.length(); j++){
//             int ch = s.charAt(j) - 'a';
//             for(int k = 0; k < 26; k++){
//                 if(k == ch) continue;
//                 ++dif[ch][k];
//                 ++difB[ch][k];
//                 difB[k][ch] = --dif[k][ch];
//                 dif[k][ch] = Math.max(dif[k][ch], 0);
//                 output = Math.max(output, Math.max(difB[ch][k], difB[k][ch]));

//             }
//         }
//         return output;
//     }
// }