import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length;
        int m = l.length;
        ArrayList<Boolean> ans = new ArrayList<>();

        int pre[] = new int[n];
        int flag = nums[1] - nums[0];

        for (int i = 1; i < n; i++) {
            pre[i - 1] = nums[i] - nums[i - 1];
        }

        for (int i = 0; i < m; i++) {
            boolean f = true; // Reset f inside the loop
            for (int j = l[i]; j < r[i] - 1; j++) {
                if (pre[j] != pre[j + 1] && pre[j] != flag) {
                    f = false;
                }
            }
            ans.add(f);
        }

        return ans;
    }
}


class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length;
        int m = l.length;
        ArrayList<Boolean> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int[] subArray = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(subArray);

            boolean isArithmetic = true;
            int diff = subArray[1] - subArray[0];

            for (int j = 2; j < subArray.length; j++) {
                if (subArray[j] - subArray[j - 1] != diff) {
                    isArithmetic = false;
                    break;
                }
            }

            ans.add(isArithmetic);
        }

        return ans;
    }
}
