class Solution {

    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;

        int high = n - 1;
        while (low <= high) {
            while (low < high && nums[low] == nums[low + 1]) ++low;
            while (low < high && nums[high] == nums[high - 1]) --high;
            int mid = low + (high - low) / 2;
            System.out.println(mid + " ");
            if (target == nums[mid]) return true;

            //    l1
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) high = mid - 1; else low = mid + 1;
            }
            //l2
            else {
                if (nums[mid] < target && target <= nums[high]) low = mid + 1; else high = mid - 1;
            }
        }
        System.gc();
        return false;
    }
}
