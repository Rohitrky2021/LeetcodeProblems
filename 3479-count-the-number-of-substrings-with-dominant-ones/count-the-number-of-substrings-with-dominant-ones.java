class Solution1 {
    public int numberOfSubstrings(String str) {
        int ans = 0;
        for (int zero = 0; zero * zero < str.length(); zero++) {
            int lastPos = -1;
            int[] count = new int[] { 0, 0 };
            for (int s = 0, e = 0; e < str.length(); e++) {
                count[str.charAt(e) - '0']++;
                while (s < e) {
                    if (str.charAt(s) == '0' && count[0] > zero) {
                        count[0]--;
                        lastPos = s;
                    } else if (str.charAt(s) == '1' && (count[1] - 1) >= (zero * zero)) {
                        count[1]--;
                    } else {
                        break;
                    }
                    s++;
                }
                if (count[0] == zero && count[1] >= count[0] * count[0])
                    ans += (s - lastPos);
            }
        }
        return ans;
    }
}

class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length(); 
        int[] prefix = new int[n]; //array to store prefix sums of '1's

        prefix[0] = ((int)(s.charAt(0) - '0')) == 1 ? 1 : 0;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + (((int)(s.charAt(i) - '0')) == 1 ? 1 : 0);
        }

        int ans = 0;

        
        for (int i = 0; i < n; i++) { //i => starting index of substring

            int one = 0; // Count of '1's in the current substring
            int zero = 0; // Count of '0's in the current substring

            for (int j = i; j < n; j++) { // j=> ending index of current substring

                one = prefix[j] - (i == 0 ? 0 : prefix[i - 1]);
                zero = (j - i + 1) - one;
              
                //CASE->1
                if ((zero * zero) > one) { // Not dominant
                    j += (zero * zero - one - 1);
                } 
                //CASE->2
                else if ((zero * zero) == one) { //just this one is dominant
                    ans++; 
                } 
                //CASE->3
                else if ((zero * zero) < one) { 
                    ans++; 
                    // Calculate the difference to determine how far to skip forward
                    int diff = (int) Math.sqrt(one) - zero;
                    int nextj = j + diff; // Determine the next position to skip to

                    if (nextj >= n) {
                        ans += (n - j - 1);
                    } else {
                        ans += diff; 
                    }

                    j = nextj; // Update j to the next position
                }
            }
        }
        return ans; // Return the final answer
    }
}

class Solution2 {
    public int numberOfSubstrings(String s) {
        int n = s.length(), ans = 0;
        int[] map = new int[n + 1];
        for (int k = 0; k * (k + 1) <= n; ++k) {
            Arrays.fill(map, n);
            map[0] = -1;
            int countZ = 0;
            for (int i = 0; i < n; ++i) {
                countZ += s.charAt(i) == '0' ? 1 : 0;
                if (map[countZ] == n) map[countZ] = i;
                if (k == 0 && s.charAt(i) == '0') continue;
                if (countZ >= k) {
                    int left = map[countZ - k];
                    int right = map[countZ - k + 1];
                    int minLen = i - right + 1;
                    int maxLen = i - left;
                    int len = Math.max(1, k * (k + 1));
                    if (len <= minLen) ans += maxLen - minLen + 1;
                    else if (len <= maxLen) ans += maxLen - len + 1;
                }
            }
        }
        return ans;
    }
}