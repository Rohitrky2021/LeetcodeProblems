/**
 * @param {string} s
 * @return {string}
 */
var shortestPalindrome = function(s) {
       let rev = s.split('').reverse().join('');
        
        // Step 2: Find the longest palindrome that starts at the beginning of `s`
        // We check by comparing prefixes of `s` and suffixes of the reversed string
        let n = s.length;
        for (let i = 0; i < n; i++) {
            // Check if the prefix of `s` matches the suffix of `rev`
            if (s.substring(0, n - i) === rev.substring(i)) {
                // Step 3: Append the non-palindrome part of the reverse string to the front
                return rev.substring(0, i) + s;
            }
        }
        
        return "";
};