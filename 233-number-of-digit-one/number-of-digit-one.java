import java.util.Arrays;

class Solution {
    static int[][][] dp;
    static String s;
//    static int N = s.length() + 1; // Add 1 to cover the end position
//    static int M = s.length() + 1; // Add 1 to cover the maximum count of digits

    static int solve(int pos, int cnt, int t) {
        // Base case: if the position reaches the end of the string
        if (pos == s.length()) {
            // Return value for the base case
            return cnt; // Assuming you want to return 0 when pos reaches the end
        }

        // If the value is already computed, return it
        if (dp[pos][cnt][t] != -1) {
            return dp[pos][cnt][t];
        }

        // Calculate the limit based on the flag t
        int lim = t != 0 ? s.charAt(pos) - '0' : 9;
        int ans = 0;

        // Loop to iterate over the possible digits at this position
        for (int i = 0; i <= lim; i++) {
            // Recursive call to the next position, updating the sum
            ans += solve(pos + 1, (i== 1 ? cnt + 1 : cnt), (t != 0 && (i == lim ? true : false) )==true?1:0);
        }

        // Store the computed value in dp array
        return dp[pos][cnt][t] = ans;
    }
    
    public int countDigitOne(int n) {
        // Initialize dp array
        
        // Convert n to string
        s = String.valueOf(n);

      
        
        // Initialize the dp array
        int N = s.length() + 1; // Add 1 to cover the end position
        int M = s.length() + 1; // Add 1 to cover the maximum count of digits
        dp = new int[N][M][2];
        
        // Initialize dp array with -1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // Call the solve function with initial parameters
        return solve(0, 0, 1);
    }
}
