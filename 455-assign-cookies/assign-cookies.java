class Solution {
    public int findContentChildren(int[] g, int[] s) {
       Arrays.sort(g);
       Arrays.sort(s);
       int count=0;
       int j=0,i=0;

       if(s.length==0 || g.length==0){
           return 0;
       }

       while(i<g.length && j<s.length){
           if(j<s.length && g[i]<=s[j] ){
               count++;
               j++;
               i++;
           }else{
            //    i++;
               j++;
           }
               
       }
       return count;
     
       }
        
    }
