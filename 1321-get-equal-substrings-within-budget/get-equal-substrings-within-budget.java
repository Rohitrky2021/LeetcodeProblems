class Solution {

    public int equalSubstring(String s, String t, int maxCost) {
        char sa[] = s.toCharArray();
        char st[] = t.toCharArray();

        int tail = 0, ans = 0, sum = 0,   head/* makeing it global */;
        for (head = 0; head < st.length; head++) {
            
            sum += Math.abs(sa[head] - st[head]);

            while (sum > maxCost) {
                sum -= Math.abs(sa[tail] - st[tail]);

                tail++;
            }

            ans = Math.max(ans, head - tail + 1);
        }

        // return head-tail+1;
        return ans;
    }
}
