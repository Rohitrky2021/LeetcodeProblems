import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int minLen = Integer.MAX_VALUE, start = 0;

        // Populate the frequency map with characters from t
        for (char ch : t.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        int i = 0, j = 0, count = mp.size();

        while (j < s.length()) {
            char currentChar = s.charAt(j);

            // Check if the current character is in the map
            if (mp.containsKey(currentChar)) {
                mp.put(currentChar, mp.get(currentChar) - 1);
                if (mp.get(currentChar) == 0) {
                    count--;
                }
            }

            // When all characters are matched
            while (count == 0) {
                char startChar = s.charAt(i);

                // Update the minimum window size
                if (mp.containsKey(startChar)) {
                    mp.put(startChar, mp.get(startChar) + 1);
                    if (mp.get(startChar) == 1) {
                        count++;
                        if (j - i + 1 < minLen) {
                            minLen = j - i + 1;
                            start = i;
                        }
                    }
                }

                i++;
            }

            j++;
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}


class Solution1 {

    //sliding window
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : t.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int matched = 0;
        int start = 0;
        int minLen = s.length() + 1;
        int subStr = 0;
        for (int endWindow = 0; endWindow < s.length(); endWindow++) {
            char right = s.charAt(endWindow);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) == 0) matched++;
            }

            while (matched == map.size()) {
                if (minLen > endWindow - start + 1) {
                    minLen = endWindow - start + 1;
                    subStr = start;
                }
                char deleted = s.charAt(start++);
                if (map.containsKey(deleted)) {
                    if (map.get(deleted) == 0) matched--;
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
    }
}



class Solution2 {
    public String minWindow(String s, String t) {
        int[] map = new int[128]; // Frequency map for characters in t
        int required = t.length(); // Number of characters needed in the window
        int left = 0, right = 0; // Sliding window pointers
        int minLen = Integer.MAX_VALUE; // Store the minimum length of a valid window
        int startIndex = 0; // Store the starting index of the minimum window

        // Populate the frequency map with characters from t
        for (char c : t.toCharArray())
            map[c]++;

        char[] S = s.toCharArray(); // Convert s to a char array for easy access

        // Expand the right to explore the window
        while (right < S.length) {
            if (map[S[right]] > 0) 
                required--; // Decrease the required count if the character is in t
            
            map[S[right]]--; // Reduce the frequency of the current character
            right++; // Move the right forward

            // While the window is valid (contains all characters from t)
            while (required == 0) {
                // Update the minimum window size
                if (right - left < minLen) {
                    startIndex = left;
                    minLen = right - left;
                }

                // Shrink the left to find a smaller valid window
                if (map[S[left]] == 0) 
                    required++; // Increase required if the character at left is necessary
                
                map[S[left]]++; // Restore the frequency of the character at left
                left++; // Move the left forward
            }
        }

        // Return the minimum window or an empty string if no valid window exists
        if (minLen == Integer.MAX_VALUE) 
            return "";
        
        return s.substring(startIndex, startIndex + minLen);
    }
}


class Solution3 {
    public String minWindow(String s1, String s2) {
        // Initialize an empty string to store the result
		String a = "";
		
		// Create a HashMap to store the frequency of characters in string s2
		HashMap<Character, Integer> map2 = new HashMap<>();
		for (int i = 0; i < s2.length(); i++) {
			char ch = s2.charAt(i);
			// Update the frequency of character ch in the map
			map2.put(ch, map2.getOrDefault(ch, 0) + 1);
		}

	
		
		// Initialize variables for the main algorithm
		int mct = 0; // Current match count
		int dmct = s2.length(); // Desired match count
		HashMap<Character, Integer> map1 = new HashMap<>(); // Map for string s1
		int i = -1; // Right pointer
		int j = -1; // Left pointer
		
		// Main algorithm to find the minimum window substring
		while (true) {
			boolean f1 = false; // Flag to check if there's progress from the right pointer
			boolean f2 = false; // Flag to check if there's progress from the left pointer
			
			// Move the right pointer until we have a match or reach the end of s1
			while (i < s1.length() - 1 && mct < dmct) {
				i++;
				char ch = s1.charAt(i);
				// Update frequency of character ch in map1
				map1.put(ch, map1.getOrDefault(ch, 0) + 1);
				
				// If the current character contributes to the match, increment match count
				if (map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)) {
					mct++;
				}
				f1 = true; // Progress from the right pointer
			}
			
			// Collect answer and release characters from the left pointer
			while (j < i && mct == dmct) {
				String p = s1.substring(j + 1, i + 1); // Potential minimum window substring
				// Update the result if it's empty or p is shorter than the current result
				if (a.length() == 0 || p.length() < a.length()) {
					a = p;
				}
				
				j++; // Move the left pointer
				char ch = s1.charAt(j);
				// Update frequency of character ch in map1
				if (map1.get(ch) == 1) {
					map1.remove(ch);
				} else {
					map1.put(ch, map1.get(ch) - 1);
				}
				
				// If the current character no longer contributes to the match, decrement match count
				if (map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)) {
					mct--;
				}
				f2 = true; // Progress from the left pointer
			}
			
			// If there's no progress from both pointers, exit the loop
			if (!f1 && !f2) {
				break;
			}
		}
		
		return a; // Return the minimum window substring
    }
}