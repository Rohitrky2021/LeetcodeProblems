class Solution2 {
    public void wiggleSort(int[] nums) {
        int n=nums.length;
        boolean c=true;
        c= nums[0]>nums[1];
        for(int i=0;i<nums.length-1;i++){
            int j=i+2;
            if(c){
                i++;
                j=i+1;
            while(j <n-1 && nums[i]<nums[j]){
                j++;
            }
            swap(nums,i+1,j);

     }
          
            else{
                i++;
                j=i+1;
            while(i<n-2 && j <n-1 && nums[i]>nums[j]){
                j++;
            }
            swap(nums,i+1,j);
            }

            c=!c;
        }
        
    }

    public void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        
        int[] res = new int[nums.length];
        int i=1,j=nums.length-1;
        while(i < nums.length)
        {
            res[i] = nums[j];
            j--;i+=2;
        }
        i=0;
        while(i < nums.length)
        {
            res[i] = nums[j];
            j--;i+=2;
        }
        
        for(int k=0;k<nums.length;k++)
            nums[k] = res[k];
        
        
        return ;
    }
}

class Solution3 {
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0 && nums[i] > nums[i + 1]) || (i % 2 == 1 && nums[i] < nums[i + 1])) {
                swap(nums, i, i + 1);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
