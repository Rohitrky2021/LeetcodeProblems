class Solution {
    /**
     *
     Just DFS+Memo
     For each cell we have 3 states -> 0: empty, 1: intro, 2: extro
     Only previous N bits matter (previous 1 is left, previous N is up)
     Naturally, we use Ternary to construct our prevN bit mask
     There are totally 3^5 = 243 combinations, meaning the prevN value is bounded by 243. (n <= 5)

     For each cell: try all possibilities: 0, 1 or 2
     0: do nothing, move our prevN bit mask with new 0 bit.
     1: happiness 120, move our prevN bit mask with new 1 bit.
     2: happiness 40, move our prevN bit mask with new 2 bit.
     Check up and left cells to determine how many extra happiness need to be added/subtracted.

     * @param m
     * @param n
     * @param introvertsCount
     * @param extrovertsCount
     * @return
     */
    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        return helper(m, n, 0, 0, introvertsCount, extrovertsCount, 0,
                new Integer[m][n][introvertsCount + 1][extrovertsCount + 1][243]);
    }

    int helper(int m, int n, int x, int y, int iCount, int eCount, int prevN, Integer[][][][][] dp) {
        // next row
        if (y == n) {
            x++;
            y = 0;
        }

        // out of people
        if (iCount == 0 && eCount == 0)
            return 0;

        // out of the matrix
        if (x == m)
            return 0;

        // Memo
        if (dp[x][y][iCount][eCount][prevN] != null)
            return dp[x][y][iCount][eCount][prevN];

        // leave the cell empty
        int res = helper(m, n, x, y + 1, iCount, eCount, set(prevN, 0), dp);

        int up = get(prevN, n - 1); // up bit is at (n - 1);
        int left = get(prevN, 0); // the rightmost is left;

        // put an introverts in the cell
        if (iCount > 0) {
            int tmp = prevN;

            prevN = set(prevN, 1);
            int addOn = 120; // newly added cell

            if (x - 1 >= 0 && up != 0) {
                addOn -= 30; // sub self
                if (up == 1)
                    addOn -= 30;
                else
                    addOn += 20;
            }

            if (y - 1 >= 0 && left != 0) {
                addOn -= 30;
                if (left == 1)
                    addOn -= 30;
                else
                    addOn += 20;
            }

            res = Math.max(res, helper(m, n, x, y + 1, iCount - 1, eCount, prevN, dp) + addOn);

            // setback for future
            prevN = tmp;
        }

        // put an extroverts in the cell
        if (eCount > 0) {
            int tmp = prevN;

            prevN = set(prevN, 2);
            int addOn = 40;

            if (x - 1 >= 0 && up != 0) {
                addOn += 20; // add self
                if (up == 1)
                    addOn -= 30;
                else
                    addOn += 20;
            }

            if (y - 1 >= 0 && left != 0) {
                addOn += 20;
                if (left == 1)
                    addOn -= 30;
                else
                    addOn += 20;
            }

            res = Math.max(res, helper(m, n, x, y + 1, iCount, eCount - 1, prevN, dp) + addOn);

            // setback for future
            prevN = tmp;
        }

        return dp[x][y][iCount][eCount][prevN] = res;
    }

    int get(int prevN, int i) {
        prevN /= (int) Math.pow(3, i);

        return prevN % 3;
    }
    
    int set(int prevN, int val) {
        return (prevN * 3 + val) % 243;
    }
}