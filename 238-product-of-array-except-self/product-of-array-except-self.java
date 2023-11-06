// class Solution {

//     public int[] productExceptSelf(int[] nums) { // Create 2 array of Right and lEft product
//         int[] ans = new int[nums.length];
//         int[] left = new int[nums.length];

//         int[] right = new int[nums.length];
 
//         left[0] = nums[0];
//         right[nums.length - 1] = nums[nums.length - 1];
//         for (int i = 1; i < nums.length; i++) {
//             left[i] = left[i - 1] * nums[i];
//         }
//         for (int i = nums.length - 2; i >= 0; i--) {
//             right[i] = right[i + 1] * nums[i];
//         }

//         ans[0] = right[1];
//         ans[nums.length - 1] = left[nums.length - 2];
//         for (int i = 1; i < nums.length - 1; i++) {
//             ans[i] = left[i - 1] * right[i + 1];
//         }

//         return ans;
//     }
// }

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] a = new int[n];
        int[] l = new int[n];
        int[] r = new int[n];
 
        l[0] = nums[0];
        r[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            l[i] = l[i - 1] * nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            r[i] = r[i + 1] * nums[i];
        }

        a[0] = r[1];
        a[n - 1] = l[n - 2];
        for (int i = 1; i < n - 1; i++) {
            a[i] = l[i - 1] * r[i + 1];
        }

        return a;
    }
}
