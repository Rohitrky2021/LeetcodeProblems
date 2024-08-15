class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] ans = {0, 0, 0}; // ans[0] -> $5 bills, ans[1] -> $10 bills

        for (int x : bills) {
            if (x == 5) {
                ans[0]++; // increase count of $5 bills
            } else if (x == 10) {
                if (ans[0] == 0) { // no $5 bills to give change
                    return false;
                }
                ans[0]--; // give one $5 bill as change
                ans[1]++; // increase count of $10 bills
            } else if (x == 20) {
                if (ans[1] > 0 && ans[0] > 0) { // give one $10 bill and one $5 bill as change
                    ans[1]--;
                    ans[0]--;
                } else if (ans[0] >= 3) { // give three $5 bills as change
                    ans[0] -= 3;
                } else { // unable to give change
                    return false;
                }
            }
        }
        return true;
    }
}
