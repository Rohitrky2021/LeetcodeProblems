// class Solution {    // Failed Not workde
//     public boolean canPartitionKSubsets(int[] nums, int k) {
//         int sum = 0;
//         for (int i : nums) {
//             sum += i;
//         }

//         if (sum % k != 0) {
//             return false; // If the total sum is not divisible by k, it's impossible to partition
//         }

//         sum /= k; // Each subset should have this target sum

//         int dp[][] = new int[nums.length + 1][sum + 1];
//         int ans[][] = new int[nums.length + 1][sum + 1];

//         for (int i = 0; i < nums.length; i++) {
//             dp[i][0] = 1;
//         }

//         for (int i = 1; i <= nums.length; i++) {
//             for (int j = 1; j <= sum; j++) {
//                 int v = nums[i - 1];
//                	if(v<=j) {
// 					dp[i][j] = dp[i-1][j]+dp[i-1][j-v];
// 				}else {
// 					dp[i][j] = dp[i-1][j];
// 				}
//             }
//         }

//            for (int i = 1; i <= nums.length; i++) {
//             for (int j = 1; j <= sum; j++) {

//                 System.out.print(dp[i][j]+" ");}
//                  System.out.println();
//                  }

//         return dp[nums.length][sum]>=k;
//     }
// }
import java.util.Arrays;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) {
            return false; // If the total sum is not divisible by k, it's impossible to partition
        }

        int target = sum / k;
        Arrays.sort(nums); // Sort the array to try larger elements first
        int n = nums.length;
        if (nums[n - 1] > target) {
            return false; // If the largest number is greater than target, partitioning is impossible
        }

        boolean[] visited = new boolean[n];
        return canPartition(nums, visited, k, 0, 0, target);
    }

    private boolean canPartition(int[] nums, boolean[] visited, int k, int startIndex, int currentSum, int target) {
        if (k == 1) {
            return true; // If we have partitioned k-1 subsets, the last subset will be valid
        }

        if (currentSum == target) {
            return canPartition(nums, visited, k - 1, 0, 0, target); // One subset is found, move to the next
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (!visited[i] && currentSum + nums[i] <= target) {
                visited[i] = true;
                if (canPartition(nums, visited, k, i + 1, currentSum + nums[i], target)) {
                    return true;
                }
                visited[i] = false;
            }
        }

        return false;
    }
}
