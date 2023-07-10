class Solution {
    public int romanToInt(String s) {
                int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='I') ans+=1;
             if(s.charAt(i)=='V')ans+=5;
            if(s.charAt(i)=='X')ans+=10;
            if(s.charAt(i)=='L')ans+=50;
            if(s.charAt(i)=='C')ans+=100;
            if(s.charAt(i)=='D')ans+=500;
            if(s.charAt(i)=='M')ans+=1000;

                        

            
           
        }
            if(s.contains("IV") || s.contains("IX") )ans-=2*1;
              if(s.contains("XC") || s.contains("XL") )ans-=2*10;
            if(s.contains("CD") || s.contains("CM") )ans-=2*100;

        return ans;
    }
}