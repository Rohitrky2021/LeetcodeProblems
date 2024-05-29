import java.math.BigInteger;

class Solution {
    public int numSteps(String s) {
        BigInteger n = new BigInteger(s, 2); // Parse binary string to BigInteger
        int count = 0;
        BigInteger two = new BigInteger("2");
        BigInteger one = new BigInteger("1");
        while (!n.equals(one)) {
            if (n.mod(two).equals(BigInteger.ZERO)) {
                n = n.divide(two);
            } else {
                n = n.add(one);
            }
            count++;
        }
        return count;
    }
}
