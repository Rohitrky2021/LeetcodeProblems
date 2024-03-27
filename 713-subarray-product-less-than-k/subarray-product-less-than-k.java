class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        // hook is ==>  the number of contiguous subarrays

        if(k<=1)return 0;

        int tail = 0, ans = 0, sum = 1,   head/* makeing it global */;
        for (head = 0; head < arr.length; head++) {
            
            sum *= arr[head];

            while (sum >=k && tail<arr.length ) {
                sum /= arr[tail];

                tail++;
            }

            ans +=head-tail+1;
        }

        // return head-tail+1;
        return ans ;
    }
}