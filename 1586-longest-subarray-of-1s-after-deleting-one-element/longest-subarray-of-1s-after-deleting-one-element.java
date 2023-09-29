// class Solution {
//     public int longestSubarray(int[] nums) {
//        int left = 0;
//         int right = 0;
//         int zeros = 0;
//         int maxLen = 0;

//         while (right < nums.length) {
//             if (nums[right] == 0) {
//                 zeros++;
//             }

//             while (zeros > 1) {
//                 if (nums[left] == 0) {
//                     zeros--;
//                 }
//                 left++;
//             }

//             maxLen = Math.max(maxLen, right - left + 1);
//             right++;
//         }

//         return maxLen-1;
//     }
// }

class Solution {
    public int longestSubarray(int[] arr) {
        int tail = 0, ans = 0, sum = 0,   k=1, head/*makeing it global */;
        for (head = 0; head < arr.length; head++) {
            if(arr[head]==0)k--;
            ans=Math.max(ans,head-tail);

            
            while (k<0) {
            if(arr[tail]==0)k++;
                tail++;
            }

            ans = Math.max(ans, head - tail + 1);
        }

        // return head-tail+1;
        return ans-1;
    }
}