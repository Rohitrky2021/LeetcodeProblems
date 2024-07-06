class Solution {
    public int passThePillow(int n, int t) {
        if(t<n)return t+1;
        int rounds=t/(n-1);
        int left=t % (n-1);
        System.out.println(rounds+" "+left );

        if(rounds%2==0){
            return left+1;
        }else{
            return n-left;
        }

        
    }
}
          
// 1 2 3 4 3 2 1 2 3 4 3  2  1 
// 0 1 2 3 4 5 6 7 8 9 10 11 12
// 0 1 2 3 0 1 2 3 0 1  2  3  4