import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        // Count frequencies of remainders
        for (int num : arr) {
            int remainder = ((num % k) + k) % k;  // Handle negative remainders
            mp.put(remainder, mp.getOrDefault(remainder, 0) + 1);
        }

        // Check conditions for pairs
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int remainder = entry.getKey();
            int count = entry.getValue();
            
            // Case 1: remainder == 0, must be even
            if (remainder == 0) {
                if (count % 2 != 0) return false;
            }
            // Case 2: remainder + complementary remainder == k
            else {
                int complement = k - remainder;
                if (mp.getOrDefault(complement, 0) != count) {
                    return false;
                }
            }
        }

        return true;
    }
}
