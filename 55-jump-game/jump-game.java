class Solution1 {
    public boolean canJump(int[] nums) {
        int last = nums.length - 1;
        int maxReach = 0; // Maximum index we can reach
        
        for (int i = 0; i <= maxReach; i++) { // maxreach boundary increase hogiu then only 
            maxReach = Math.max(maxReach, i + nums[i]);
            
            if (maxReach >= last) {
                return true; // We can reach the last index
            }
        }
        
        return false; // Cannot reach the last index
    }
}

class Solution2{
    public boolean canJump(int[] nums) {

        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        for (int i = dp.length - 1; i >= 0; i--) {
            if (dp[i]) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] >= i - j) {
                        dp[j] = true;
                        if (dp[0])
                            return true;
                    }
                }
            }
        }
        return dp[0];
    }
}

class Solution3 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        return jumpFrom(0,nums);
    }
    public static boolean jumpFrom(int index , int[] nums){
        if(index>=nums.length-1)
          return true;
        
        for(int i=1;i<=nums[index];i++){
            if(jumpFrom(index + i , nums)==true)
             return true;
        }

        return false;
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return jumpFrom(0,nums,dp);
    }
    public static boolean jumpFrom(int index , int[] nums,int[] dp){
        if(index>=nums.length-1)
          return true;

        if(dp[index]!=-1)
         return dp[index]==0?false:true;
        
        for(int i=1;i<=nums[index];i++){
            if(jumpFrom(index + i , nums,dp)==true)
            { dp[index]=1;
              return true;
            }
        }

        dp[index]=0;
        return false;
    }
}