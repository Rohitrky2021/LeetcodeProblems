class Solution {
    public int trap(int[] h) {
        int n=h.length;
        int left[]=new int[n];
         left[0]=h[0];

        for(int i=1;i<n;i++){
            left[i]=Math.max(h[i],left[i-1]);
        }  

        int right[]=new int[n];
        right[n-1]=h[n-1];
        for(int i=n-2;i>=0;i--){
            right[i]=Math.max(h[i],right[i+1]);
        }
        int trap=0;
        for(int i=0;i<n;i++){
            // int maxh=Math.min(Math.abs(right[i]-left[i]));---> if want the max section 
            int maxh=Math.min(right[i],left[i]);
           trap+=maxh-h[i];
        } 
        return trap;     
    }
}



// public class Trapping_Rainwater {
//     public static int trap(int[] height) {
         
//            // (BruteForce) Solution 1: Time Complexity: O(N^2) & Space Complexity: O(1)
//            int n = arr.length;
//            int waterTrapped = 0;
//            for (int i = 0; i < n; i++) {
//                int j = i;
//                int leftMax = 0, rightMax = 0;
//                while (j >= 0) {
//                    leftMax = Math.max(leftMax, arr[j]);
//                    j--;
//                }
//                j = i;
//                while (j < n) {
//                    rightMax = Math.max(rightMax, arr[j]);
//                    j++;
//                }
//                waterTrapped += Math.min(leftMax, rightMax) - arr[i];
//            }
//            return waterTrapped;
         
         
//             // Solution 2: Time Complexity: O(3N) & Space Complexity: O(2N)
//             int[] premax = new int[height.length];
//             int[] suffmax = new int[height.length];
//             int max = Integer.MIN_VALUE;
//             for(int i = 0; i < height.length; i++){
//                 max = Math.max(max, height[i]);
//                 premax[i] = max;
//             }
//             max = Integer.MIN_VALUE;
//             for(int i = height.length - 1; i >= 0; i--){
//                 max = Math.max(max, height[i]);
//                 suffmax[i] = max;
//             }
//             int[] res = new int[height.length];
//             for(int i = 0; i < height.length; i++){
//                 res[i] = Math.min(premax[i], suffmax[i]) - height[i];
//             }
//             int ans = 0;
//             for(int i = 0; i < res.length; i++){
//                 ans += res[i];
//             }
//             return ans;
      
        
//         // Soution 3: Time Complexity: O(N) & Space Complexity: O(1).
//         int n = height.length; 
//         int left = 0, right = n - 1;
//         int maxLeft = 0, maxRight = 0;
//         int res = 0;
//         while(left <= right){
//             if(height[left] <= height[right]){
//                 if(height[left] >= maxLeft){
//                     maxLeft = height[left];
//                 }
//                 else{
//                     res += maxLeft - height[left];
//                 }
//                 left++;
//             }
//             else{
//                 if(height[right] >= maxRight){
//                     maxRight = height[right];
//                 }
//                 else{
//                     res += maxRight - height[right];
//                 }
//                 right--;
//             }
//         }
//         return res;
//     }
//     public static void main(String[] args) {
//         int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
//         System.out.println(trap(arr));
//     }
// }
