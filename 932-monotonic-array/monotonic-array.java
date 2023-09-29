class Solution {

    public boolean isMonotonic(int[] nums) {
        return isSortedl(nums)||isSortedr(nums);
    }

    public static boolean isSortedl(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isSortedr(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
