class Solution {
    public int getLucky(String s, int k) {

        // Convert the string to its numerical form
        StringBuilder sb = new StringBuilder();
        for (char x : s.toCharArray()) {
            sb.append(x - 'a' + 1);
        }

        // Convert the string to the sum of its digits k times
        while (k-- > 0) {
            int sum = 0;
            for (char c : sb.toString().toCharArray()) {
                sum += c - '0';
            }
            sb = new StringBuilder(Integer.toString(sum));
        }

        return Integer.parseInt(sb.toString());
    }
}
