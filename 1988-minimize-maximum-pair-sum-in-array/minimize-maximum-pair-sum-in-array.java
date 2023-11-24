class Solution{
    public int minPairSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int l=0,r=n-1;
        int maxi=0;

        while(l<r){
          maxi=Math.max(maxi,nums[l]+nums[r]);
          l++;
          r--;
        }
        return maxi;
    }
}


class Solution11{
    public int minPairSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        return Math.max(nums[0]+nums[n-1],nums[1]+nums[n-2]);
    }
}





class Solution5 {
    public int minPairSum(int[] nums) {
        int max = 0;
        for (int n : nums) if (n > max) max = n;
        int[] count = new int[max + 1];
        for (int n : nums) count[n]++;
        int y = 0, i = 1, j = max;
        while (i <= j) {
            while (count[i] <= 0) i++;
            while (count[j] <= 0) j--;
            y = Math.max(y, i + j);
            if (count[i] > count[j]) count[i] -= count[j--];
            else if (count[j] > count[i]) count[j] -= count[i++];
            else {
                i++;
                j--;
            }
        }
        return y;
    }
}



class Solution3 {
    public int minPairSum(int[] nums) {
        // Find maximum value in nums[] array.
        int maxNum = 0;
        for (final int num : nums)  if (num > maxNum)  maxNum = num;
        
        // Get count of the frequency of each value in the 
        // nums[] array.
        final byte[] counts = new byte[maxNum + 1];
        for (final int num : nums)  counts[num]++;
        
        // Scan from both the left and right of the counts[] 
        // array, to get pairs of numbers.  The left index 
        // in the counts array gets the next low value, and 
        // the right index in the counts array gets the high 
        // value.
        int maxPairSum = 0;
        int left = 0;
        int right = maxNum;
        while (counts[++left] == 0)  { }
        while (left <= right) {
            maxPairSum = Math.max(maxPairSum, left + right);
            if (counts[left] == counts[right]) {
                while (counts[++left] == 0)  { }
                while (counts[--right] == 0)  { }
            } else if (counts[left] < counts[right]) {
                counts[right] -= counts[left];
                while (counts[++left] == 0)  { }
            } else {
                counts[left] -= counts[right];
                while (counts[--right] == 0)  { }
            }
        }
        
        return maxPairSum;
    }
}