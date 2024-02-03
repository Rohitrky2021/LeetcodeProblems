class Solution {
    public String triangleType(int[] nums) {
         HashSet<Integer> s=new HashSet<>();
        int or=0;
        int c=0;
        int sum=0;
        
        for(int x:nums){
           sum+=x;
        }

        for(int x:nums){
            or=or^x;
            if(s.contains(x)) c++; 
            s.add(x);
            
            if((sum-x)<=x) return "none";
        }
        
        if(!s.contains(or))   return "scalene";  
        if(c==2) return "equilateral";
       
        return "isosceles";

        
    }
}