class Solution1 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if( nums.length==1 || nums[0]!=nums[1] ){
            return nums[0];
        }
          if(nums[nums.length-1]!=nums[nums.length-2]){
            return nums[nums.length-1];
        }

        for(int i=1;i<nums.length-1;i++){
            if(nums[i-1]!=nums[i] && nums[i+1]!=nums[i]  ){
            return nums[i];
            // break;
            }
        }
        return 0; 
    }
}


class Solution2 {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<32;i++){
            int ones=0,zero=0;
            int temp=1<<(i);

            for(int num:nums){
                if((num & temp)==0)zero++;
                else ones++;
            }
            if(ones%3!=0){
                ans|=temp;
            }
        }

        return ans;
    }
}


class Solution {
    public int singleNumber(int[] nums) {
       int ones = 0, twos = 0;
        for (int n : nums) {
            ones = (ones ^ n) & ~twos;
            twos = (twos ^ n) & ~ones;
        }
        return ones;
    }
}

