import java.util.ArrayList;
import java.util.Collections;

class Solution {
    private static final int MOD = 1000000007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Long> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                ans.add(sum);
            }
        }

        Collections.sort(ans);

        long totalSum = 0;
        for (int i = left - 1; i < right; i++) {
            totalSum = (totalSum + ans.get(i)) % MOD;
        }

        return (int) totalSum;
    }
}
