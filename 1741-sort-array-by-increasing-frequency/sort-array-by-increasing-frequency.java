import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;

        int[][] arr = new int[201][2];  // Adjusted size to accommodate negative values

        for (int i = 0; i < nums.length; i++) {
            arr[nums[i] + 100][0] = nums[i];  // Adjust index to handle negative values
            arr[nums[i] + 100][1]++;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];  // Sort by frequency
            } else {
                return b[0] - a[0];  // Sort by value if frequencies are the same
            }
        });

        int[] ans = new int[n];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            while (arr[i][1] > 0) {
                ans[index++] = arr[i][0];
                arr[i][1]--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 2, 2, 2, 3};
        System.out.println(Arrays.toString(sol.frequencySort(nums)));
    }
}
