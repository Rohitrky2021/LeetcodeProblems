// import java.util.HashMap;
// import java.util.Map;

// class Solution {
//     public int minimumCardPickup(int[] a) {
//         Map<Integer, Integer> count = new HashMap<>();
//         int tail = 0, ans = Integer.MAX_VALUE, max = 0;

//         for (int head = 0; head < a.length; head++) {
//             int currentFruit = a[head];

//             count.put(currentFruit, count.getOrDefault(currentFruit, 0) + 1);
//              // Use getOrDefault to handle null values

//             // Check if the window needs adjustments to have at most two types of fruit
//             while (count.getOrDefault(a[head], 0) >1 && tail < a.length) {
//                 ans = Math.min(ans, head - tail + 1);

//                 count.put( a[tail], count.getOrDefault( a[tail], 0) - 1);

//                 tail++;

//             }
//         }

//         return ans == Integer.MAX_VALUE ? -1 : ans;
//     }
// }
class Solution {

    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            if (map.containsKey(cards[i])) min = Math.min(i - map.get(cards[i]) + 1, min); // Check if the difference in indices is smaller than minimum
            map.put(cards[i], i); // Update the last found index of the card
        }
        return min == Integer.MAX_VALUE ? -1 : min; // Repetition found or not
    }
}
