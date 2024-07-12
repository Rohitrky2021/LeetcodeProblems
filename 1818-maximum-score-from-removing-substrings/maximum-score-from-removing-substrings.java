class Solution1 {   // TLE in this 
    public int maximumGain(String s, int x, int y) {

        if (s.length() < 2) return 0;

        int takex = 0, takey = 0;

        if (x > y) {
            while (s.contains("ab")) {
                s = s.replaceFirst("ab", "");
                takex += x;
            }
            while (s.contains("ba")) {
                s = s.replaceFirst("ba", "");
                takey += y;
            }
        } else {
            while (s.contains("ba")) {
                s = s.replaceFirst("ba", "");
                takey += y;
            }
            while (s.contains("ab")) {
                s = s.replaceFirst("ab", "");
                takex += x;
            }
        }

        return takex + takey;
    }
}

 
class Solution2 {  // N^2 also will not work her 
    private HashMap<String, Integer> memo = new HashMap<>();

    public int maximumGain(String s, int x, int y) {
        if (s.length() < 2) return 0;

        // Check if the result is already computed
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        int takex = 0, takey = 0;

        // Case when we take "ab"
        if (s.contains("ab")) {
            takex = maximumGain(s.replaceFirst("ab", ""), x, y) + x;
        }

        // Case when we take "ba"
        if (s.contains("ba")) {
            takey = maximumGain(s.replaceFirst("ba", ""), x, y) + y;
        }

        // Get the maximum of the two cases
        int ans = Math.max(takex, takey);

        // Store the result in the memoization map
        memo.put(s, ans);

        return ans;
    }
}

class Solution3 {
    public int maximumGain(String s, int x, int y) {
        int res = 0;
        String top, bot;
        int top_score, bot_score;

        if (y > x) {
            top = "ba";
            top_score = y;
            bot = "ab";
            bot_score = x;
        } else {
            top = "ab";
            top_score = x;
            bot = "ba";
            bot_score = y;
        }

        // Removing first top substrings cause they give more points
        StringBuilder stack = new StringBuilder();
        for (char ch : s.toCharArray()) { // Changed 'char' to 'ch'
            if (ch == top.charAt(1) && stack.length() > 0 && stack.charAt(stack.length() - 1) == top.charAt(0)) {
                res += top_score;
                stack.setLength(stack.length() - 1);
            } else {
                stack.append(ch);
            }
        }

        // Removing bot substrings cause they give less or equal amount of scores
        StringBuilder new_stack = new StringBuilder();
        for (char ch : stack.toString().toCharArray()) { // Changed 'char' to 'ch'
            if (ch == bot.charAt(1) && new_stack.length() > 0 && new_stack.charAt(new_stack.length() - 1) == bot.charAt(0)) {
                res += bot_score;
                new_stack.setLength(new_stack.length() - 1);
            } else {
                new_stack.append(ch);
            }
        }

        return res;
    }
}

class Solution {
    private int removePairs(StringBuilder s, String target) {
        int write_ind = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            s.setCharAt(write_ind, s.charAt(i));
            write_ind++;
            if (write_ind >= 2 && s.charAt(write_ind - 1) == target.charAt(1) && s.charAt(write_ind - 2) == target.charAt(0)) {
                count++;
                write_ind -= 2;
            }
        }
        s.setLength(write_ind);
        return count;
    }

    public int maximumGain(String s, int x, int y) {
        int res = 0;
        StringBuilder sb = new StringBuilder(s);
        String top, bot;
        int top_score, bot_score;

        if (y > x) {
            top = "ba";
            top_score = y;
            bot = "ab";
            bot_score = x;
        } else {
            top = "ab";
            top_score = x;
            bot = "ba";
            bot_score = y;
        }

        res += removePairs(sb, top) * top_score;
        res += removePairs(sb, bot) * bot_score;
        return res;
    }
}