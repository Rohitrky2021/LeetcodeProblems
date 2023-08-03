import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wl = words[0].length();
        int wordn = words.length * wl;
        int sn = s.length();
        List<Integer> arr = new ArrayList<>();

        var frequencyMap = new HashMap<String, Integer>();

        for (String i : words) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }

        for (int i = 0; i <= sn - wordn; i++) {
            var curr = new HashMap<String, Integer>();
            int j;
            for (j = 0; j < words.length; j++) {
                int subind = i + j * wl;
                var subs = s.substring(subind, subind + wl);

                if (!frequencyMap.containsKey(subs)) {
                    break;
                }

                curr.put(subs, curr.getOrDefault(subs, 0) + 1);

                if (curr.get(subs) > frequencyMap.getOrDefault(subs, 0)) {
                    break;
                }
            }
            if (j == words.length ) {
                arr.add(i);
            }
        }

        return arr;
    }

    private boolean mapEquals(Map<String, Integer> map1, Map<String, Integer> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }
        for (var entry : map1.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (map2.getOrDefault(key, 0) != value) {
                return false;
            }
        }
        return true;
    }
}
