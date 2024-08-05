import java.util.HashMap;

class Solution {
    public String kthDistinct(String[] arr, int k) {
        // Using HashMap to store the frequency of each string
        HashMap<String, Integer> freq = new HashMap<>();

        for (String x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        int count = 0;
        String ans = "";

        // Iterating through the array to maintain the order of first appearance
        for (String x : arr) {
            if (freq.get(x) == 1) {
                count++;
                if (count == k) {
                    ans = x;
                    break;
                }
            }
        }

        return ans;
    }
}
