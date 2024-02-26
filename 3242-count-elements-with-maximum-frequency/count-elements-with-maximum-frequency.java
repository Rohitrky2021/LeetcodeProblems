class Solution {
    public int maxFrequencyElements(int[] nums) {

        int fre[]=new int[101];

        for(int x:nums){
            fre[x]++;
        }

        int max=Arrays.stream(fre).max().orElse(0);

        int count=0;

        for(int i=0;i<101;i++){
            if(fre[i]==max)count++;
        }

        return count*max;
        
    }
}