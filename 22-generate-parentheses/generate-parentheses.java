// class Solution {

//     public List<String> generateParenthesis(int n) {
//         List<String> ans = new ArrayList<>();
//         helper(0, n, ans, 0, "");
//         return ans;
//     }

//     public List<String> helper(int close, int n, List<String> ans, int open, String s) {
//         if (open == n && close == n) {
//             ans.add(s);
//             return ans;
//         }
//         int i=0;

//         if (open < n) helper(close, n, ans, open + 1, s + "("); 

//         if (close < open) helper(close + 1, n, ans, open, s + ")"); // If condition is important here

//         return ans;
//     }
// }
 

// Now Using Tabulation DP 

class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        List<List<String>> dp = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<String>());
        }
        
        dp.get(0).add("");
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                for (String str1 : dp.get(j)) {
                    for (String str2 : dp.get(i - j - 1)) {
                        dp.get(i).add("(" + str1 + ")" + str2);
                    }
                }
            }
        }
        
        return dp.get(n);
    }
}
