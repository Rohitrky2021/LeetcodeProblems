class Solution {
    public int numSubarrayBoundedMax0(int[] nums, int left, int right) {
        int ans = 0, low = 0, mid = 0;
        for (int num : nums) {
            if (num > right) mid = 0;
            else ans += ++mid;

            if (num >= left) low = 0;
            else ans -= ++low;
        }
        return ans;
    }


    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int i=0;
        int j=0;
        int ans=0;
        int smaller=0;
        
        while(i!=A.length){
            
            if(A[i]>=L && A[i]<=R){
                smaller=i-j+1;
                ans+=smaller;
            }else if(A[i]<L){
                ans+=smaller;
            }else{
                j=i+1;
                smaller=0;
            }
            i++;
        }
        return ans;
    }
}

