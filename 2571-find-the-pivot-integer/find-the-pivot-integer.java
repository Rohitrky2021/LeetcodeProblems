class Solution {

    public int pivotInteger(int n) {

        int T=(n*(n+1))/2;

        int sum=0,ans=-1;

        for(int i=1;i<=n;i++){
            sum+=i;
            if(2*sum==T+i)ans=i;
        }

        return ans;

    }
}
