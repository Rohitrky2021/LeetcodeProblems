class Solution1 {
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

class Solution2 {

    public int numberOfSubarrays(int[] nums, int k) {
        int currSum = 0, subarrays = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(currSum, 1);

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i] % 2;
            // Find subarrays with sum k ending at i
            if (prefixSum.containsKey(currSum - k)) {
                subarrays = subarrays + prefixSum.get(currSum - k);
            }
            // Increment the current prefix sum in hashmap
            prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
        }

        return subarrays;
    }
}

class Solution4 {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] map = new int[50001];
        int sum = 0;
        map[0] = 1;
        int count = 0;
        int goal = k;
        for (int i = 0; i < n; i++) {
            sum += nums[i] % 2;
            if (sum >= goal) {
                count += map[sum - goal];
            }
            map[sum]++;
        }
        return count;
    }
}

class Solution {
    public int helpMe(int[] nums, int goal) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int cnt = 0;
        if (goal < 0) {
            return 0;
        }
        while (r < nums.length) {
            sum += nums[r] % 2; ////// <------
            while (sum > goal) {
                if (nums[l] % 2 == 1) { //// <-------
                    sum--;
                }
                l++;
            }
            cnt = cnt + r - l + 1;
            r++;
        }
        return cnt;
    }

    public int numberOfSubarrays(int[] nums, int k) {

        return helpMe(nums, k) - helpMe(nums, k - 1);
    }

}

class Solution3 { /// THis is Not working at aall later if u come again try
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
                ans++;
            }

        }

        return ans;
    }
}
