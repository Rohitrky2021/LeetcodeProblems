class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
       int[] result = getAbsoluteSumDifference(nums);
        
        // Print the result
       return result;
    }
 static int[] getAbsoluteSumDifference(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Compute the sum of differences for elements to the left of each element
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            result[i] += i * nums[i] - leftSum;
            leftSum += nums[i];
        }

        // Compute the sum of differences for elements to the right of each element
        int rightSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            result[i] += rightSum - (n - 1 - i) * nums[i];
            rightSum += nums[i];
        }

        return result;
    }
}