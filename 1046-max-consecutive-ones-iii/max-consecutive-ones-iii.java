class Solution {

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
        return Math.max(ans,head-tail);
    }
}
