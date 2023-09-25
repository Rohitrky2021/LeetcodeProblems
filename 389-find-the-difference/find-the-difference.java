class Solution {

    // public char findTheDifference(String s, String t) {
    //    char a1[]=s.toCharArray();
    //     char a2[]=t.toCharArray();

    //     Arrays.sort(a1);
    //     Arrays.sort(a2);
    //     for (int i = 0; i < a1.length; i++) {
    //         if(a1[i]!=a2[i])return a2[i];
    //     }

    //       return a2[s.length()];
    // }

    public char findTheDifference(String s, String t) {
        Map<Character, Integer> hs = new HashMap<>();
        for (char c : s.toCharArray()) {
            hs.put(c, hs.getOrDefault(c, 0) + 1);
        }
        for (char i : t.toCharArray()) {
            if ( hs.get(i) == null || hs.get(i) == 0 ) return i;
            if (hs.containsKey(i)) {
                hs.put(i, hs.getOrDefault(i, 0) - 1);
            }
        }

        return 'k';
    }
}
