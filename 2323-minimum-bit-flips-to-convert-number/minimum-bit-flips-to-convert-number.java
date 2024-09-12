class Solution1 {
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


class Solution {
    public int minBitFlips(int start, int goal) {
        // XOR the two numbers to get the bits that differ
        int xor = start ^ goal;

        // Count the number of 1s in the XOR result (i.e., the number of differing bits)
        int count = 0;
        while (xor > 0) {
            count += xor & 1;  // Check the least significant bit
            xor >>= 1;         // Shift right to check the next bit
        }

        return count;
    }
}
