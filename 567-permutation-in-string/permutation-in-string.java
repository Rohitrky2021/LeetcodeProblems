


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        boolean flag= false;

        Map<Character , Integer> m1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            m1.put( ch , m1.getOrDefault( ch , 0 )+1  );
        }
        for (int i = 0; i <=s2.length()-s1.length(); i++) {
            Map<Character , Integer> m2 = new HashMap<>();
            for (int j = i; j < i+s1.length(); j++) {
                char ch = s2.charAt(j);
                m2.put( ch , m2.getOrDefault( ch , 0 )+1  );
            }
            if( m1.equals(m2) ) {
                flag=true;
                break;
            }
        }
        return flag ;
    }
}


 class Solution5 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (s1map[i] == s2map[i])
                count++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
            if (count == 26)
                return true;
            s2map[r]++;
            if (s2map[r] == s1map[r]) {
                count++;
            } else if (s2map[r] == s1map[r] + 1) {
                count--;
            }
            s2map[l]--;
            if (s2map[l] == s1map[l]) {
                count++;
            } else if (s2map[l] == s1map[l] - 1) {
                count--;
            }
        }
        return count == 26;
    }
}


  class Solution4 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        HashMap<Character, Integer> s1map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++)
            s1map.put(s1.charAt(i), s1map.getOrDefault(s1.charAt(i), 0) + 1);

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            HashMap<Character, Integer> s2map = new HashMap<>();
            for (int j = 0; j < s1.length(); j++) {
                s2map.put(s2.charAt(i + j), s2map.getOrDefault(s2.charAt(i + j), 0) + 1);
            }
            if (matches(s1map, s2map))
                return true;
        }
        return false;
    }

    public boolean matches(HashMap<Character, Integer> s1map, HashMap<Character, Integer> s2map) {
        for (char key : s1map.keySet()) {
            if (s1map.get(key) - s2map.getOrDefault(key, -1) != 0)
                return false;
        }
        return true;
    }
}

  class Solution3 {
    public boolean checkInclusion(String s1, String s2) {
        s1 = sort(s1);
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (s1.equals(sort(s2.substring(i, i + s1.length()))))
                return true;
        }
        return false;
    }
    
    public String sort(String s) {
        char[] t = s.toCharArray();
        Arrays.sort(t);
        return new String(t);
    }
}


  class Solution2{
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

   class Solution0 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        for (int i = 0; i < s1.length(); i++)
            s1map[s1.charAt(i) - 'a']++;
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2map = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                s2map[s2.charAt(i + j) - 'a']++;
            }
            if (matches(s1map, s2map))
                return true;
        }
        return false;
    }
    
    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
}