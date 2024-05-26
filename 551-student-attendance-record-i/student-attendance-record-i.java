class Solution {
    public boolean checkRecord(String s) {

        char last = '@';
        char curr;
        int ca = 0, maxl = 0, l = 0;

        for (char x : s.toCharArray()) {
            curr = x;
            if (x == 'A') ca++;

            if (curr == 'L') l++;
            else if (curr != 'L') l = 0;
            last = curr;

            maxl = Math.max(maxl, l);
        }

        return ca < 2 && maxl < 3;
    }
}
