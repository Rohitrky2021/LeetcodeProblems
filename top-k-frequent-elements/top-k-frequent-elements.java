// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
        
//     }
// }
import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
Comparator.comparingInt(num -> frequencyMap.get(num))
        );

        for (int num : frequencyMap.keySet()) {
            priorityQueue.offer(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

       int[] topKElements = new int[k];
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            topKElements[index++] = priorityQueue.poll();
        }

        return topKElements;

    }
}
