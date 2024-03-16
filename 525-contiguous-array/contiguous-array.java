class Solution1 {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] p0 = new int[n];
        int[] p1 = new int[n];

        if (nums[0] == 0) p0[0] = 1;
        if (nums[0] == 1) p1[0] = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] == 0) {
                p0[i] = p0[i - 1] + 1;
                p1[i] = p1[i - 1];
            } else {
                p1[i] = p1[i - 1] + 1;
                p0[i] = p0[i - 1];
            }
        }

        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int countZeros = p0[j] - (i > 0 ? p0[i - 1] : 0);
                int countOnes = p1[j] - (i > 0 ? p1[i - 1] : 0);
                if (countZeros == countOnes) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }
}

 

class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        int maxLength = 0;
        
        for (int i = 0; i < n; i++) {
            count += (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxLength = Math.max(maxLength, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        
        return maxLength;
    }
}

