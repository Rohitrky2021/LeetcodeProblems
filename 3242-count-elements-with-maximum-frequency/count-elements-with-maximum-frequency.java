class Solution {
    public int maxFrequencyElements(int[] nums) {

        int fre[]=new int[101];
        int max=0;

        for(int x:nums){
            fre[x]++;

            max=Math.max(max,fre[x]);
        }

        

        int count=0;

        for(int i=0;i<101;i++){
            if(fre[i]==max)count++;
        }

        return count*max;
        
    }
}