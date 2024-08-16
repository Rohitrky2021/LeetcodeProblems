import java.util.List;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        // Initialize min and max with the first array's first and last elements
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int result = 0;
        
        // Iterate through the arrays starting from the second array
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentArray = arrays.get(i);
            int currentMin = currentArray.get(0);
            int currentMax = currentArray.get(currentArray.size() - 1);
            
            // Calculate the potential maximum distance
            result = Math.max(result, Math.max(Math.abs(currentMax - min), Math.abs(max - currentMin)));
            
            // Update the global min and max
            min = Math.min(min, currentMin);
            max = Math.max(max, currentMax);
        }
        
        return result;
    }
}
