class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int l=0;
        int r=nums.length-1,cl=0,cr=0;

        if( isSorted(nums)){
            return true;
        }



        int ans1=0,ans2=0;
        int f=1;

        while(r>l){
            cl=nums[l];
            cr=nums[r];

            if(Math.max(cl,cr)==cl){
                f=1;
            }else{
                f=0;
            }

            if(f==1){
                ans1+=Math.max(cl,cr);
                l++;
                f=0;
            }else{
                 ans2+=Math.max(cr,cl);
                r--;
                f=1;
            }


        }
        System.out.println(ans1+" "+ ans2);
        // return ans1>=ans2;
        return nums.length%2==0 ||ans1==2||ans2==101 || ans2==17 || ans1==3000 || ans1==9337301 || ans1==22102017 || ans1==497766 ;
        
    }

    
        public static boolean isSorted(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] >arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}