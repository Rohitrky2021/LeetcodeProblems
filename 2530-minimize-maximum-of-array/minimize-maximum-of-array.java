class Solution1 {
    public int minimizeArrayValue(int[] nums) {
        long sum = 0;
        long res = 0;
        for (int i = 0; i <nums.length; i++) {
            sum += nums[i];
            res= Math.max(res,(sum + i) /(i + 1));
        }
        return (int)res;
    }
    // This (sum + i) is just to avoid using math.ceil in the return statement. ppl please be aware of that confusing point.
}

class Solution {
    public int minimizeArrayValue(int[] nums) {
        long sum = 0;
        long result = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
             long avgCeil = (long) Math.ceil( sum*1.0 / (i + 1));
            result = Math.max(result, avgCeil);
        }
        
        return (int) result;
    }
}


class Solution2 {
    public int minimizeArrayValue(int[] nums) {
        //從最後一位開始處理 遞補
        int left = 0;
        int right = (int) 1e9+7;

        while(left <= right){
            int mid = left + (right- left)/ 2;
            long extra = 0;//避免易位
            for(int i = nums.length - 1; i>= 0; i--){
                long total = nums[i] + extra;//避免易位
                if(total <= mid){
                    extra = 0;
                }else if(total > mid){
                    extra = total - mid;
                }
            }
            if(extra > 0){
                left = mid + 1;
            }else if(extra == 0){
                right = mid - 1;
            }
        }
        return left;
    }
}