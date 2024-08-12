class Solution {
    public int findMin(int[] nums) {
        // initializing left and right pointers.
        int left = 0, right = nums.length - 1;

        // Binary search way
        while (right > left) {
            int mid = left + (right - left) / 2;

            // If the mid element is greater than the rightmost element, the minimum must be to the right.
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // If mid element is less than the rightmost element, the minimum is either the mid element or to the left.
            else if (nums[mid] < nums[right]) {
                right = mid;
            }
            // If nums[mid] equals nums[right], we can't be sure where the minimum is, so reduce the search space.
            else {
                right--;
            }
        }

        // After the loop, left will point to the minimum element.
        return nums[left];
    }
}
