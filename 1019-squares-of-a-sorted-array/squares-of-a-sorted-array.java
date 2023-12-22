class Solution1 {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length,c=0;
        for(int i=0;i<n;i++){
            nums[i]=Math.abs(nums[i]);
        }

        Arrays.sort(nums);

        for(int i:nums){
            nums[c++]=i*i;
        }

        return nums;
        
    }
}


class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int left = 0, right = n - 1;
        int index = n - 1; // Start filling the result array from the end
        
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            
            if (leftSquare > rightSquare) {
                result[index--] = leftSquare;
                left++;
            } else {
                result[index--] = rightSquare;
                right--;
            }
        }
        
        return result;
    }
}
