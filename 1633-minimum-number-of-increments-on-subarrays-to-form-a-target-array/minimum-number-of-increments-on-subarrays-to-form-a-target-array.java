class Solution {
    public int minNumberOperations(int[] t) {
         int n = t.length;
        // int[] t = new int[n];
        
        // Calculate the difference array
        // for (int i = 0; i < n; i++) {
        //     t[i] = tar[i] - nums[i];
        // }
        
        int pos = 0;
        long m = 0, ans = 0;
        ans = Math.abs(t[0]);
        m = ans;
        
        // Determine the initial sign of the first element
        if (t[0] >= 0) pos = 1;
        
        for (int i = 1; i < n; i++) {
            // Handle sign changes
            if (t[i] < 0 && pos == 1) { //My previous was +ve & I'm Negative 
                ans += Math.abs(t[i]);
                m = Math.abs(t[i]);
                pos = 0;
                continue;
            }
            if (t[i] >= 0 && pos == 0) { //My previous was -ve & I'm +ve 
                ans += Math.abs(t[i]);
                m = Math.abs(t[i]);
                pos = 1;
                continue;
            }
            // Handle no sign change  --> //My previous was  Same as my Sign 
            if (m >= Math.abs(t[i])) { // wo prev bdaa tha merese 
                m = Math.abs(t[i]);
                continue;
            } else {                      // wo prev chotaa  tha merese 
                ans += Math.abs(t[i]) - m;  // Addd curr- Prev 
                m = Math.abs(t[i]);
            }
        }
        
        return (int)ans;
    }
}