class Solution {
    public int minimumChairs(String s) {
        int ce=0,cl=0;
        
        for(char x:s.toCharArray()){
            if(x=='E')ce++;
            else ce--;

            cl=Math.max(ce,cl);
        }

        return  cl;
    }
}