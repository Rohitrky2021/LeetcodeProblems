import java.util.*;

class Solution1 {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) // Handling edge cases
            return 0;
        
        int lcs = 1; // Minimum length of consecutive sequence
        int ans = 1; // Final answer
        HashSet<Integer> s = new HashSet<>();
        
        for(int x : nums){
            s.add(x);
        }

        for(int num : nums){
            if(!s.contains(num - 1)){ // Check if the current number starts a new sequence
                int currNum = num;
                lcs = 1;

                while(s.contains(currNum + 1)){ // Count consecutive elements
                    currNum++;
                    lcs++;
                }

                ans = Math.max(ans, lcs); // Update the maximum length
            }
        }

        return ans;
    }
}
 

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int lcs = 0;
        int ans = Integer.MIN_VALUE;
        HashSet<Integer> s = new HashSet<>();
        
        for (int x : nums) {
            s.add(x);
        }

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            // If the current element is the start of a sequence
            if (!s.contains(current - 1)) {
                int next = current + 1;
                while (s.contains(next)) {
                    next++;
                }
                lcs = Math.max(lcs, next - current);
            }
            ans = Math.max(ans, lcs);
        }

        return ans;
    }
}
