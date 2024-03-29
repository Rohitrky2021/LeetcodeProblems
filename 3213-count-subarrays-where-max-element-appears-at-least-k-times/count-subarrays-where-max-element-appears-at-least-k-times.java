class Solution {
    public long countSubarrays(int[] nums, int k) {
        // Find the maximum element in the array
        int maxElement = Arrays.stream(nums).max().getAsInt();
        
        // Initialize variables to keep track of the result, the start index of the window, and the count of maximum elements in the window
        long ans = 0;
        int start = 0, maxElementsInWindow = 0;
        long ans2=0;

        // Iterate through the array
        for (int end = 0; end < nums.length; end++) {
            // If the current element is the maximum element, increment the count of maximum elements in the window
            if (nums[end] == maxElement) {
                maxElementsInWindow++;
            }
            
            // Slide the window until the count of maximum elements in the window is equal to k
            while (k == maxElementsInWindow) {
                // If the element at the start of the window is the maximum element, decrement the count of maximum elements in the window
                ans2+=nums.length-end;
                if (nums[start] == maxElement) {
                    maxElementsInWindow--;
                }
                // Move the start index of the window forward
                start++;
            }
            
            // Add the current start index to the result, which represents the number of subarrays ending at the current end index
            ans += start;
        }

        // Return the final result
        return ans2;
    }
}

class Solution1 {
    public long countSubarrays(int[] nums, int k) {
        int maxElement = Arrays.stream(nums).max().getAsInt();
        List<Integer> indexesOfMaxElements = new ArrayList<>();
        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == maxElement) {
                indexesOfMaxElements.add(i);
            }

            int freq = indexesOfMaxElements.size();
            if (freq >= k) {
                ans += indexesOfMaxElements.get(freq - k) + 1;
            }
        }

        return ans;
    }
}