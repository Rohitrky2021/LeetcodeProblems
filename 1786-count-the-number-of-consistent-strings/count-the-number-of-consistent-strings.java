import java.util.TreeSet;

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;

        TreeSet<Character> check = new TreeSet<>();
        for (char y : allowed.toCharArray()) {
            check.add(y);
        }

        TreeSet<Character> hs = new TreeSet<>();
        for (String x : words) {
            for (char y : x.toCharArray()) {
                hs.add(y);
            }
            // Check if all characters in hs are part of check
            if (check.containsAll(hs)) count++; 
            hs.clear();
        }

        return count;
    }
}
