class Solution {
    public int minSubArrayLen(int k, int[] arr) {
          

        int tail = 0, ans =  Integer.MAX_VALUE, sum = 0,   head/* makeing it global */;
        for (head = 0; head < arr.length; head++) {
            
            sum += arr[head] ;

            while (sum > k) {
                ans=Math.min(ans, head - tail + 1);
                sum -= arr[tail];

                tail++;
            }

           if(sum>=k)ans = Math.min(ans, head - tail + 1);
        }

        // return head-tail+1;
        return ans== Integer.MAX_VALUE?0:ans;
    }
}