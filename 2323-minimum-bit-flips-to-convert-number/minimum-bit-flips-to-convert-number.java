class Solution {
    public int minBitFlips(int start, int goal) {

        String s = Integer.toBinaryString(start);
        String g = Integer.toBinaryString(goal);

        int count = 0;

        // Padding the shorter string with leading zeroes
        int max = Math.max(s.length(), g.length());
        s = String.format("%" + max + "s", s).replace(' ', '0');
        g = String.format("%" + max + "s", g).replace(' ', '0');

        // Compare bit by bit
        for (int i = 0; i < max; i++) {
            if (s.charAt(i) != g.charAt(i)) count++;
        }

        return count;
    }
}
