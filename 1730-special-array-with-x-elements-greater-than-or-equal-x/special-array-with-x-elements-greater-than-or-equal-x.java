class Solution {
    public int specialArray(int[] nums) {
        int maxNum = -1;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        
        for (int x = maxNum; x >= 0; x--) {
            int count = 0;
            for (int num : nums) {
                if (num >= x) {
                    count++;
                }
            }
            if (count == x) {
                return x;
            }
        }
        
        return -1;
    }
}
