class Solution {
    public int longestPalindrome(String st) {

        int fre[]=new int[200];

        for(char x:st.toCharArray()){
            fre[(int)x]++;
        }

        int d=0,s=0;

        for(int x:fre){
                    System.out.println("x "+x);

          d+=x/2;
          s+=x%2;
        }

        System.out.println("d "+d+" s "+s);

        return  2*d+(s==0?0:1);

    }
}