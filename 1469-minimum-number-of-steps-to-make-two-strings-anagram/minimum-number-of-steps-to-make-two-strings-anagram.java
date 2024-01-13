class Solution {
    public int minSteps(String s, String t) {
      return  t.length()- isAnagram(s,t);

    }

    public int isAnagram(String s, String t) {
        int ci=0;
        if (s.length() != t.length())
            return 0;
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++; 
        }

        for (char c : t.toCharArray()) {
            if (count[c - 'a'] != 0){
             count[c - 'a']--; 
             ci++;

            }
        }
        // for (int i = 0; i < 26; i++) {
        //     if (count[i] != 0)
        //       ci++;
        // }
        return ci;
    }
}