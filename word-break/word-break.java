class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> words = new HashSet<>(wordDict);
        dp[0] = true;
        //dp[i] means the result to the problem s[0:i]
        for(int end = 1; end <= s.length(); ++ end) {
            for(int start = 0; start < end; ++ start) {
                if(dp[start] && words.contains(s.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}