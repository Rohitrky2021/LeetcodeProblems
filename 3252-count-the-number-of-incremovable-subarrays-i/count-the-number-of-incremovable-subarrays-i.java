class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int count = 0;
        
        for (int start = 0; start < nums.length; start++) {
            for (int end = start; end < nums.length; end++) {
                if (isIncremovable(nums, start, end)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
        private boolean isIncremovable(int[] nums, int start, int end) {
    int lastNumberUsed = Integer.MIN_VALUE; // Initialize the last number used as the smallest possible integer
    
    // Check if removing subarray makes the remaining elements strictly increasing
    for (int i = 0; i < nums.length; i++) {
        if (i >= start && i <= end) {
            continue; // Skip elements within the subarray range
        }
        
        if (lastNumberUsed >= nums[i]) {
            return false; // If the current number is not greater than the last used number, array isn't strictly increasing
        }
        
        lastNumberUsed = nums[i]; // Update the last used number
    }
    
    return true;
}

}
