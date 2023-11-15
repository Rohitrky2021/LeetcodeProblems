class Solution {
   public int getXORSum(int[] arr1, int[] arr2) {
         int xor1=0 , xor2=0;
         for(int val:arr1) xor1^=val;
         for(int val:arr2) xor2^=val;
        return (xor1&xor2);
    }
}

