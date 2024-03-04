class Solution {
    public int finalValueAfterOperations(String[] oper) {
        int ans=0;

        int plus=0,minus=0;

        for(String x:oper){
            if( x.equals("X--")|| x.equals("--X"))minus++;
             if(x.equals("X++")|| x.equals("++X"))plus++;
        }
 
        return plus-minus;
    }
}