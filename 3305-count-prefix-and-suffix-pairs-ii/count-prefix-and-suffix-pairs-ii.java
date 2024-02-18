import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public long countPrefixSuffixPairs(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        long ans = 0;
        Set<Integer> lens = new HashSet<>();
        for (String word : words) {
            int wordLen = word.length();
            for (int len : lens) {
                if (len > wordLen) continue;
                String prefix = word.substring(0, len);
                String suffix = word.substring(wordLen - len, wordLen);

                if (prefix.equals(suffix) && map.containsKey(prefix)) {
                    ans += (long) map.get(prefix);
                }
            }
            map.put(word, map.getOrDefault(word, 0) + 1);
            lens.add(word.length());
        }
        return ans;
    }
}
