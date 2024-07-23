import java.util.*;

class Solution1 {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;

        int[][] arr = new int[201][2];  // Adjusted size to accommodate negative values

        for (int i = 0; i < nums.length; i++) {
            arr[nums[i] + 100][0] = nums[i];  // Adjust index to handle negative values
            arr[nums[i] + 100][1]++;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];  // Sort by frequency
            } else {
                return b[0] - a[0];  // Sort by value if frequencies are the same
            }
        });

        int[] ans = new int[n];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            while (arr[i][1] > 0) {
                ans[index++] = arr[i][0];
                arr[i][1]--;
            }
        }

        return ans;
    }
 
}


class Solution2 {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Java's Arrays.sort method doesn't directly support
        // sorting primitive arrays (int[]) with a lambda comparator.
        // We can convert the primitive int into Integer objects
        // to get around this limitation.
        Integer[] numsObj = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsObj[i] = nums[i];
        }

        Arrays.sort(numsObj, (a, b) -> {
            if (freq.get(a).equals(freq.get(b))) {
                return Integer.compare(b, a);
            }
            return Integer.compare(freq.get(a), freq.get(b));
        });

        // Convert numsObj back to a primitive array to match
        // return type.
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsObj[i];
        }

        return nums;
    }
}

 
class Solution {
    public int[] frequencySort(int[] nums) {
        // Count frequencies using a TreeMap
        Map<Integer, Integer> freqMap = new TreeMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Create a priority queue that sorts first by frequency, then by value (in reverse order)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];  // Sort by frequency
            } else {
                return b[0] - a[0];  // Sort by value if frequencies are the same
            }
        });

        // Add all entries from the frequency map to the priority queue
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        // Build the result array
        int[] ans = new int[nums.length];
        int index = 0;
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            for (int i = 0; i < pair[1]; i++) {
                ans[index++] = pair[0];
            }
        }

        return ans;
    }

   
}
