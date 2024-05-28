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

//  Using Binar Search 

class Solution1 {
    public int equalSubstring(String s, String t, int maxCost) {
        // Calculate the prefix sum to get the cost of `s.substring(i, length)`
        int n = s.length();
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + Math.abs(s.charAt(i) - t.charAt(i));
        }

        // Binary search the maximum length
        int l = 0, r = n;
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (check(prefix, maxCost, m)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    // Check if there exists a substring that meets the condition
    private boolean check(int[] prefix, int maxCost, int length) {
        for (int i = 0; (i + length) <= prefix.length; i++) {
            int cost = prefix[i + length] - prefix[i];
            if (cost <= maxCost) {
                return true;
            }
        }
        return false;
    }
}
