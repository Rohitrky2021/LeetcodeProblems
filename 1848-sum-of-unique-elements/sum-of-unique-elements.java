class Solution {
    public int sumOfUnique(int[] arr) {
         int f[] = new int[2040];

       int ans=0;

        for (int i = 0; i < arr.length; i++) {
            f[arr[i]]++;
        }
 

        for (int i = 1; i < f.length; i++) {
            if( f[i]==1)ans+=i;
        }
        return ans;
    }
}