class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int fre[]=new int[52];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            fre[nums[i]]++;
            
        }
        for(int i=0;i<51;i++){
          if(fre[i]==2)sum^=i;
          fre[i]--;
            
        }

        return sum;
        
    }
}