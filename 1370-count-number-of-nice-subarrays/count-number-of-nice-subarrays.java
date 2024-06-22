class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int c = 0; // count of odd numbers
        int tail = 0, ans = 0, sum = 0;
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 1; // base case

        for (int head = 0; head < nums.length; head++) {
            if (nums[head] % 2 != 0)
                c++;

            if (c >= k)
                ans += prefix[c - k];

            prefix[c]++;
        }

        return ans;
    }
}

class Solution1 {   /// THis is Not working at aall later if u come again try 
    public int numberOfSubarrays(int[] nums, int k) {
        int c = 0; // count of odd numbers
        int tail = 0, ans = 0;
       

        for (int head = 0; head < nums.length; head++) {
            if (nums[head] % 2 != 0) {
                c++;
            }

            while (c > k) {
                if (nums[tail] % 2 != 0) {
                    c--;
                }
                tail++;
            }

            if (c == k) {
                ans ++;
            }
 
        }

        return ans;
    }
}
