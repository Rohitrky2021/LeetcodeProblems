class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
        }
        int unique = count.size();

        int[] countArray = new int[100000];
        for(Integer key : count.keySet()) {
            int keyCount = count.get(key);
            countArray[keyCount]++;
        }

        for (int i = 1; i < 100000; i++) {
            if (countArray[i]!= 0) {
                int remove = k / i;
                if (remove == 0) {
                    break;
                } else {
                    remove = Math.min(remove, countArray[i]);
                    unique -= remove;
                    k -= remove * i;
                }
            }
        }
        return unique;
    }
}

class Solution1 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // Step 1: Store the frequency of each element in the array
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Sort the frequencies in ascending order
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(frequencyMap::get));
        minHeap.addAll(frequencyMap.keySet());

        // Step 3: Traverse through the frequencies until the sum of frequencies is greater than or equal to k
        while (k > 0 && !minHeap.isEmpty() && frequencyMap.get(minHeap.peek()) <= k) {
            k -= frequencyMap.get(minHeap.poll());
        }

        // Step 4: Calculate the number of unique elements left after considering the top k frequencies
        return minHeap.size();
    }
}
