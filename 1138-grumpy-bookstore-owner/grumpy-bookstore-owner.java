class Solution2 {  // THis was the Greedy way it Failed by me just here to remember later
    public int maxSatisfied(int[] c, int[] g, int minutes) {
        int n = c.length;

        int check = 0;
        int edge=0;
        for (int i = 0; i < n; i++) {
            if (g[i] == 0) {
                check += c[i];
            }
            edge+=c[i];
        }

        // If there are only 1 or 2 customers, return the sum of all customers
        if (n == 1 || n == 2 || n==3) {
            return edge;
        }

        // Calculate suffix sums of satisfied customers
        int[] suff = new int[n];
        suff[0] = c[0] + c[1];
        suff[n - 1] = c[n - 1] + c[n - 2];
        for (int i = 1; i < n - 1; i++) {
            suff[i] = (g[i - 1] != 0 ? c[i - 1] : 0) + (g[i + 1] != 0 ? c[i + 1] : 0);
        }

        // Calculate max satisfied customers
        int maxSatisfied = check;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            if (i > 0 && g[i - 1] == 0) {
                curr += c[i - 1];
            }
            if (i < n - 1 && g[i + 1] == 0) {
                curr += c[i + 1];
            }
            maxSatisfied = Math.max(maxSatisfied, check + suff[i] - curr);
        }

        return maxSatisfied;
    }
}


class Solution1 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = grumpy.length;
        int i = 0;
        int curWin = 0;
        int maxWin = 0;

        for(int j=0;j<n;j++) {
            curWin+=customers[j] * grumpy[j];
            maxWin = Math.max(curWin, maxWin);
            if(j >= minutes - 1 ) {   // start taking out the  sum when u get the legnth required 
                curWin -= customers[i] * grumpy[i++]; // increase the tail as well 
            }
        }
        int res = maxWin;
        for(i=0;i<grumpy.length;i++) {
            res+=customers[i] * (1 - grumpy[i]);
        }
        return res;

    }
}

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = grumpy.length;
        int tail = 0;
        int curWin = 0;
        int maxWin = 0;

        for(int head = 0; head < n; head++) {
            curWin += customers[head] * grumpy[head];
            maxWin = Math.max(curWin, maxWin);
            if(head >= minutes - 1) {   // start taking out the sum when you get the length required
                curWin -= customers[tail] * grumpy[tail++]; // increase the tail also  as now length is vailf always this if will also be valid 
            }
        }
        int res = maxWin;
        for(tail = 0; tail < grumpy.length; tail++) {
            res += customers[tail] * (1 - grumpy[tail]); // add the innitail max people satiisifed altready 
        }
        return res;
    }
}
