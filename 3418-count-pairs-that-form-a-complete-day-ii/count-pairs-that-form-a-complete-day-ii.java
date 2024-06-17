import java.util.HashMap;

class Solution {
    public long countCompleteDayPairs(int[] hours) {
        HashMap<Long, Long> remainderCount = new HashMap<>();
        long count = 0;

        for (long hour : hours) {
            long remainder = hour % 24;
            long complement = (24 - remainder) % 24;

            if (remainderCount.containsKey(complement)) {
                count += remainderCount.get(complement);
            }

            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0L) + 1);
        }

        return   count;
    }

  
}
