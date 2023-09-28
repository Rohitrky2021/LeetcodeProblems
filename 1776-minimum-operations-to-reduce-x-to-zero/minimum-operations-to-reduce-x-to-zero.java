// class Solution {
//    public int minOperations(int[] nums, int x) {
// 	int sum = 0;
// 	for (int num: nums) sum += num;

// 	int maxLength = -1, currSum = 0;
// 	for (int l=0, r=0; r<nums.length; r++) {
// 		currSum += nums[r];
// 		while (l <= r && currSum > sum - x) currSum -= nums[l++];
// 		if (currSum == sum - x) maxLength = Math.max(maxLength, r-l+1);
// 	}

// 	return maxLength == -1 ? -1 : nums.length - maxLength;
// }
// }
public class Solution {
    public int minOperations(int[] nums, int x) {
        int target = -x, n = nums.length;
        for (int num : nums) target += num;
        
        if (target == 0) return n;
        
        int maxLen = 0, curSum = 0, left = 0;
        
        for (int right = 0; right < n; ++right) {
            curSum += nums[right];
            while (curSum > target && left<n) {
                curSum -= nums[left];
                left++;
            }
            if (curSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        
        return maxLen != 0 ? n - maxLen : -1;
    }
}

// class Solution {

//     long[] dp;

//     public int minOperations(int[] nums, int x) {
//         dp = new long[x + 1];
//         Arrays.fill(dp, -1);
//         long minOperations = recursiveMinOperations(nums, x, 0, nums.length - 1);
//         return minOperations==0?-1:minOperations >= Long.MAX_VALUE ? -1 : (int) minOperations;
//     }

//     private long recursiveMinOperations(int[] nums, int x, int left, int right) {
//         if (x == 0) {
//             return 0;
//         }

//         if (left > right || x < 0) {
//             return Long.MAX_VALUE;
//         }

//         if (dp[x] != -1) {
//             return dp[x];
//         }

//         // Remove the leftmost element and explore the subproblem
//         long removeLeft = recursiveMinOperations(nums, x - nums[left], left + 1, right);

//         // Remove the rightmost element and explore the subproblem
//         long removeRight = recursiveMinOperations(nums, x - nums[right], left, right - 1);

//         // Take the minimum of the two possibilities and add 1 operation for the current step
//         return dp[x] = Math.min(removeLeft, removeRight) + 1;
//     }
// }

// class Solution {

//        public int minOperations(int[] nums, int x) {
//         int minOperations = recursiveMinOperations(nums, x, 0, nums.length - 1);
//         return minOperations == Integer.MAX_VALUE ? -1 : minOperations;
//     }

//     private int recursiveMinOperations(int[] nums, int x, int left, int right) {
//         if (x == 0) {
//             return 0;
//         }

//         if (left > right || x < 0) {
//             return Integer.MAX_VALUE;
//         }

//         // Remove the leftmost element and explore the subproblem
//         int removeLeft = recursiveMinOperations(nums, x - nums[left], left + 1, right);

//         // Remove the rightmost element and explore the subproblem
//         int removeRight = recursiveMinOperations(nums, x - nums[right], left, right - 1);

//         // Take the minimum of the two possibilities and add 1 operation for the current step
//         int minOperations = Math.min(removeLeft, removeRight) + 1;

//         return minOperations;
//     }
// }

