import java.util.*;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        // TreeMap to store time in minutes as key and the frequency as value
        TreeMap<Integer, Integer> timeMap = new TreeMap<>();
        
        // Convert time points to minutes and store in TreeMap
        for (String time : timePoints) {
            String[] arr = time.split(":");  // Split time into hours and minutes
            int hours = Integer.parseInt(arr[0]);
            int minutes = Integer.parseInt(arr[1]);
            int totalMinutes = hours * 60 + minutes; // Convert to total minutes from 00:00
            
            // If time is already in the map, it means duplicate times, hence the minimum difference is 0
            if (timeMap.containsKey(totalMinutes)) {
                return 0;
            }
            timeMap.put(totalMinutes, 1);
        }
        
        // To find the minimum difference
        int ans = Integer.MAX_VALUE;
        int prevTime = -1;
        int firstTime = -1;
        int lastTime = -1;
        
        // Traverse through the sorted time map
        for (int time : timeMap.keySet()) {
            if (prevTime != -1) {
                // Calculate the difference between consecutive times
                ans = Math.min(ans, time - prevTime);
            } else {
                // Set the first time to calculate circular difference (midnight crossover)
                firstTime = time;
            }
            prevTime = time;
            lastTime = time;
        }
        
        // Handle the circular case (difference between the last time and the first time, crossing midnight)
        ans = Math.min(ans, (24 * 60) - lastTime + firstTime);
        
        return ans;
    }
}
