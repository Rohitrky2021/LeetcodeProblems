class Solution {
    public int numWaterBottles(int numsBottles, int numExchange) {

        if(numsBottles<numExchange)return numsBottles;
        int ans=numsBottles;

        while(numsBottles>=numExchange){
           int div= numsBottles/numExchange;
           int remin=numsBottles%numExchange;
           ans+=div;

           numsBottles=div+remin;

        }

        return ans;

         
    }
}