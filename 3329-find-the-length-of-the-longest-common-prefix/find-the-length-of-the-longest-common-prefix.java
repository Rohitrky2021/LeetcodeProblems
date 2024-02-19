import java.util.HashSet;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int n = arr1.length;
        HashSet<String> hs = new HashSet<>();

        // Convert integer arrays to strings and populate HashSet with substrings from arr1
        for (int i = 0; i < n; i++) {
            String str = String.valueOf(arr1[i]);
            for (int j = 0; j < str.length(); j++) {
                hs.add(str.substring(0, j + 1)); // corrected substring index
            }
        }

        int max = Integer.MIN_VALUE;
        // Convert integer arrays to strings and iterate over arr2 to find the longest common prefix
        for (int i = 0; i < arr2.length; i++) {
            String str = String.valueOf(arr2[i]);
            for (int j = str.length() - 1; j >= 0; j--) {
                if (hs.contains(str.substring(0, j + 1))) { // corrected substring index
                    max = Math.max(max, j + 1); // corrected to include current character
                    break;
                }
            }
        }

        return max == Integer.MIN_VALUE ? 0 : max; // return 0 if no common prefix found
    }
}
