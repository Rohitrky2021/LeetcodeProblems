class Solution {
    // https://leetcode.ca/2017-03-31-487-Max-Consecutive-Ones-II/

    // https://leetcode.ca/2018-08-30-1004-Max-Consecutive-Ones-III/

    public int longestOnes(int[] arr, int k) {
        // int k = 0;
        int tail = 0, ans = 0, sum = 0, targetsum = k, head/*makeing it global */;
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
        return ans;
    }
}
