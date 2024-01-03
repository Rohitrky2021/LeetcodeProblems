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