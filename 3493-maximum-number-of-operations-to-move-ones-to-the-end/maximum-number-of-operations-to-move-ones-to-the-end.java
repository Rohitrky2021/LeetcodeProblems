class Solution {
    public int maxOperations(String s) {
        int count=0;
        int ans=0;
        char sa[]=s.toCharArray();
         for(int i=0;i<s.length()-1;i++){
            if(sa[i+1]=='0' && sa[i]=='1'){
                count++;
                ans+=count;
            } 
             else if(sa[i]=='1'){
                count++;
            }
         }

         return ans;
        
    }
}