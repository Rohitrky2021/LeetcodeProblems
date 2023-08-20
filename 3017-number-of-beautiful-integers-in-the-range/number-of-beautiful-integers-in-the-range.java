

   
class Solution {
    
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        return count(0,4,4,k,low,high);
        
    }
    
     public int count(int val, int odd, int even, int k,int low, int high){
        
        if(val>high)return 0;
        int ans=0;
        if(val%k==0 && val>=low && val<=high && odd==even)ans=1;
        if(even==0 && odd ==0)return ans;
        if(even>0){
             ans+= count(val*10+2,odd, even-1,k,low,high) 
                   + count(val*10+4,odd, even-1,k,low,high)
                   + count(val*10+6,odd, even-1,k,low,high)
                   + count(val*10+8,odd, even-1,k,low,high) ;
            if(val>0)ans+= count(val*10+0,odd, even-1,k,low,high);
        }
         if(odd>0){
            ans+= count(val*10+1,odd-1, even,k,low,high) 
                 +count(val*10+3,odd-1, even,k,low,high)
                 +count(val*10+5,odd-1, even,k,low,high)
                 +count(val*10+7,odd-1, even,k,low,high)
                 +count(val*10+9,odd-1, even,k,low,high);
         }
         return ans;
     }

}