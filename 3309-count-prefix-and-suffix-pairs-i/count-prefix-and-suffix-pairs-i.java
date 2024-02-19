import java.util.HashSet;

class Solution {
    public int countPrefixSuffixPairs(String[] wd) {
        int n = wd.length;
       
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j && (wd[j].startsWith(wd[i]) && wd[j].endsWith(wd[i]))) {
                    count++;
                }
            }
        }

        return count;
    }
}
