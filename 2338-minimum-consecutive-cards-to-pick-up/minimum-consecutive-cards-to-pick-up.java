import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minimumCardPickup(int[] a) {
        Map<Integer, Integer> count = new HashMap<>();
        int tail = 0, ans = Integer.MAX_VALUE, max = 0;

        for (int head = 0; head < a.length; head++) {
            int currentFruit = a[head];

            count.put(currentFruit, count.getOrDefault(currentFruit, 0) + 1);
             // Use getOrDefault to handle null values

            // Check if the window needs adjustments to have at most two types of fruit
            while (count.getOrDefault(a[head], 0) >1 && tail < a.length) {
                ans = Math.min(ans, head - tail + 1);
         
                count.put( a[tail], count.getOrDefault( a[tail], 0) - 1);

             
                tail++;
           
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
