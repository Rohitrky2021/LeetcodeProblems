import java.util.*;

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int leftCount = 0, pivotCount = 0, rightCount = 0;

        // Count elements smaller, equal, and greater than pivot
        for (int num : nums) {
            if (num < pivot) leftCount++;
            else if (num == pivot) pivotCount++;
            else rightCount++;
        }

        // Create result array
        int[] result = new int[nums.length];
        int leftIndex = 0, pivotIndex = leftCount, rightIndex = leftCount + pivotCount;

        // Place elements into correct positions
        for (int num : nums) {
            if (num < pivot) result[leftIndex++] = num;
            else if (num == pivot) result[pivotIndex++] = num;
            else result[rightIndex++] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {5, 3, 8, 4, 2, 7, 1, 5, 5, 3};
        int pivot = 5;
        System.out.println(Arrays.toString(sol.pivotArray(nums, pivot)));
    }
}
