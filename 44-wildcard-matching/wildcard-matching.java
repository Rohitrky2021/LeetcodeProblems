class Solution1 {
    public boolean isMatch(String s, String p) {
        
        int n = s.length();
        int m = p.length();

        int[][] dp = new int[n][m];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return memo(s,p,n-1,m-1,dp);
    }

     public static boolean memo(String s, String p, int i, int j, int[][] dp){

        if(i < 0 && j < 0){
            return true;
        }

        if( i < 0 && j>= 0){
            for(int x=0; x<=j;x++){
                if(p.charAt(x) != '*') return false;
            }
            return true;
        }
        else if(j < 0 && i>=0 ){  // because in j i.e p is the only pattern Available 
            return false;
        }

        if(dp[i][j] != -1) return dp[i][j] == 0 ? false : true;

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            boolean val = memo(s,p,i-1,j-1,dp);
            dp[i][j] = val == true ? 1 : 0; // store kr lena then ans neeche return kr dena 
            return val;
        }else if(p.charAt(j) == '*'){
            boolean val =  (memo(s,p,i,j-1,dp) || memo(s,p, i-1, j,dp) || memo(s,p,i-1,j-1,dp));
            dp[i][j] = val == true ? 1 : 0;
            return val;
        }
        else {
            dp[i][j] = 0;
            return false;
        }
    }
}


class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        
        // Initialize HashMap for memoization
        HashMap<String, Boolean> map = new HashMap<>();
        
        // Start recursion from the end of both strings
        return memo(s, p, n - 1, m - 1, map);
    }

    public static boolean memo(String s, String p, int i, int j, HashMap<String, Boolean> map) {
        // Base cases
        if (i < 0 && j < 0) {
            return true; // Both strings exhausted
        }
        
        if (i < 0 && j >= 0) {
            // s is exhausted, check if remaining p is all '*'
            for (int x = 0; x <= j; x++) {
                if (p.charAt(x) != '*') return false;
            }
            return true;
        } else if (j < 0 && i >= 0) {
            // p is exhausted, s still has characters
            return false;
        }

        // Create the key for HashMap
        String key = i + " " + j;
        
        // Check if result is already memoized
        if (map.containsKey(key)) {
            return map.get(key);
        }

        // Case 1: Characters match or p has '?'
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            boolean val = memo(s, p, i - 1, j - 1, map);
            map.put(key, val); // Store result
            return val;
        }
        
        // Case 2: p has '*'
        else if (p.charAt(j) == '*') {
            boolean val = (memo(s, p, i, j - 1, map) ||   // '*' matches empty
                           memo(s, p, i - 1, j, map) ||   // '*' matches one or more
                           memo(s, p, i - 1, j - 1, map)); // '*' matches single char
            map.put(key, val); // Store result
            return val;
        }
        
        // Case 3: No match
        else {
            map.put(key, false); // Store false
            return false;
        }
    }
}