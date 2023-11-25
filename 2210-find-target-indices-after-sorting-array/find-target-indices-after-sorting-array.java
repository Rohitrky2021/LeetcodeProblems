import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] fre = new int[101];
        int occu = 0;

        // Count occurrences of each element in nums
        for (int num : nums) {
            fre[num]++;
        }

        // Calculate the total occurrences of elements smaller than target
        for (int i = 0; i < target; i++) {
            occu += fre[i];
        }

        // Add indices of the target element to the result in sorted order
        for (int i = 0; i < fre[target]; i++) {
            ans.add(occu + i);
        }

        return ans;
    }
}
