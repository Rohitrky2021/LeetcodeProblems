import java.util.*;

class Solution {
    
    public int maximizeGreatness(int[] nums) {
        // Sort the nums array
        // Arrays.sort(nums);
        
        // Use a TreeMap to store the elements and their frequencies
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        
        // Populate the TreeMap with the frequencies of the elements
        for (int num : nums) {
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
        }
        
        int count = 0;
        
        // Iterate through the original array nums
        for (int num : nums) {
            // Find the smallest number in the TreeMap that is greater than num
            Integer greater = treeMap.higherKey(num);
            
            if (greater != null) {
                // We have found a valid number that is greater than num, so we count this
                count++;
                
                // Decrease the frequency of this number in the TreeMap
                if (treeMap.get(greater) == 1) {
                    treeMap.remove(greater);  // Remove the element if its count becomes 0
                } else {
                    treeMap.put(greater, treeMap.get(greater) - 1);  // Reduce its count
                }
            }
        }
        
        return count;
    }
}
