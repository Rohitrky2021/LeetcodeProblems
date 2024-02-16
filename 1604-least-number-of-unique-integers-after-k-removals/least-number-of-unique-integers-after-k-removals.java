import java.util.*;

class Solution1{
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int[][] cf = new int[100001][2]; 
        
        
        for (int c : arr) {
            cf[c][0] = c;  
            cf[c][1]++;    
             
        }

        int count = 0;
      
         for (int i = 0; i <k; i++) {  
             if(cf[i][1]!=0){
             count+=cf[i][1];
             }else{
                 k++;
             }
 
         }

        return arr.length-count;  
    }
}

 

class Solution {
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
