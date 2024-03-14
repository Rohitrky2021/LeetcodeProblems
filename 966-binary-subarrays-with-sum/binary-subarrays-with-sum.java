class Solution1 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int pre[] = new int[nums.length];
        pre[0] = nums[0]; // Initialize pre[0]

        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] + nums[i]; // Calculate prefix sum
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i == 0 && pre[j] == goal) {
                    count++; // Handle the case when the entire array sums up to the goal
                } else if (i > 0 && pre[j] - pre[i - 1] == goal) {
                    count++; // Check subarrays starting at index i
                }
            }
        }

        return count;
    }
}

 
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        Map<Integer, Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0, 1); // To handle subarrays starting from index 0
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;
            int complement = prefixSum - goal;
            count += prefixSumFreq.getOrDefault(complement, 0);
            prefixSumFreq.put(prefixSum, prefixSumFreq.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
