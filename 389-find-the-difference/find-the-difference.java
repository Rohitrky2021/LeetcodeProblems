class Solution {

    public char findTheDifference(String s, String t) {
        char a1[] = s.toCharArray();
        char a2[] = t.toCharArray();

        Arrays.sort(a1);
        Arrays.sort(a2);
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) return a2[i];
        }

        return a2[s.length()];
    }
}
