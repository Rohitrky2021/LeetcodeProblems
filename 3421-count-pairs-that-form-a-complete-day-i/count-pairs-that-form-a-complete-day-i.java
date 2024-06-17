import java.util.HashMap;

class Solution {
    public int countCompleteDayPairs(int[] hours) {
        HashMap<Integer, Integer> remainderCount = new HashMap<>();
        int count = 0;

        for (int hour : hours) {
            int remainder = hour % 24;
            int complement = (24 - remainder) % 24;

            if (remainderCount.containsKey(complement)) {
                count += remainderCount.get(complement);
            }

            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //   cases
        int[] hours1 = {12, 12, 30, 24, 24};
        int[] hours2 = {72, 48, 24, 3};

        System.out.println(solution.countCompleteDayPairs(hours1));  
        System.out.println(solution.countCompleteDayPairs(hours2)); // Output: 3
    }
}
