public class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long count = 0;
        int left = 0;
        int right = 0;
        int n = nums.length;
        
        while (right < n) {
            // Expand the window until it's not alternating
            while (right < n - 1 && nums[right] != nums[right + 1]) {
                right++;
            }
            
            // Calculate the length of the alternating subarray
            int length = right - left + 1;
            
            // Add the number of subarrays of alternating length to the count
            count +=(long) length * (length + 1) / 2;
            
            // Move the left pointer to the next position
            left = right + 1;
            right = left;
        }
        
        return count;
    }
    
 
}
