class Solution {
    public int[] singleNumber(int[] nums) {
        int grpA=0;
        int grpB=0;
        int x=0;

        for(int num:nums){
            x^=num;
        }

        int mask=x&((~x+1));

        for(int num:nums){
            if((num & mask)!=0){
                grpA^=num;
            }else{
                grpB^=num;
            }
        }



         
       return new int[]{grpA,grpB};
    }
}
