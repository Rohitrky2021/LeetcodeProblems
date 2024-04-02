// import java.util.HashSet;

// class Solution {

//     public int countSpecialNumbers(int n) {
//         // Call the solve function with initial parameters
//         return solve(Integer.toString(n), 0, -1, 1, new HashSet<>());
//     }

//     static int solve(String s, int pos, int prev, int tight, HashSet<Integer> set) {
//         // Base case: if the position reaches the end of the string
//         if (pos == s.length()) {
//             // Check if all digits are distinct
//             if (set.size() == pos) {
//                 return 1;
//             }
//             return 0;
//         }

//         // Initialize answer
//         int ans = 0;

//         // Calculate the limit based on the flag tight
//         int lim = tight != 0 ? s.charAt(pos) - '0' : 9;

//         // Loop to iterate over the possible digits at this position
//         for (int i = 0; i <= lim; i++) {
//             // If the current digit is equal to the previous one, skip
//             if (set.contains(i)) continue;

//             // Update the set with the current digit
//             set.add(i);
            
//             // Update the recursive call with the next position and digit
//             ans += solve(s, pos + 1, i, (tight != 0 && i == lim) ? 1 : 0, set);
            
//             // Remove the current digit from the set for backtracking
//             set.remove(i);
//         }

//         // Return the computed answer
//         return ans;
//     }
// }


// long long helper(string s , int index , bool tight, int mask = 0) {
//     if (index == s.size()) {
//         return 1;
//     }

//     if (dp[index][tight][mask] != -1) return dp[index][tight][mask];

//     int ub = (tight) ? s[index] - '0' : 9; // decied the upperbound based on tight constraint
//     long long ans = 0;

//     for (int dig = 0; dig <= ub; dig++) {
//         if ((mask >> dig) & 1) continue; //if dig is already used
//         if (dig == 0) {
// 		// only mark used if some other dig is already used
//             if (mask) ans += helper(s, index + 1 , tight & (dig == ub) ,  mask | 1);  
//             else ans += helper(s, index + 1, tight & (dig == ub) , mask);  // else don't
//         } else {
//             ans += helper(s, index + 1 , tight & (dig == ub) , mask | (1 << dig)); / mark visited and fill for next
//         }
//     }

//     return dp[index][tight][mask] = ans ;
// }

// int countSpecialNumbers(int n) {
//     string s = to_string(n);
//     memset(dp, -1, sizeof(dp));
//     return helper(s, 0, 1) - 1; // - for removing zero as ques want from [1,n];
// }
// };



 
  class Solution1 {
    static long[][][] dp = new long[22][2][1 << 10]; // dp array to store results

    public static long helper(String s, int index, boolean tight, int mask, Set<Integer> usedDigits) {
        if (index == s.length()) {
            return 1;
        }

        if (dp[index][tight ? 1 : 0][mask] != -1) return dp[index][tight ? 1 : 0][mask];

        int ub = tight ? s.charAt(index) - '0' : 9; // determine the upperbound based on tight constraint
        long ans = 0;

        for (int dig = 0; dig <= ub; dig++) {
            if (usedDigits.contains(dig)) continue; // if dig is already used
            if (dig == 0) {
                // only mark used if some other dig is already used
                if (!usedDigits.isEmpty()) {
                    ans += helper(s, index + 1, tight && (dig == ub), mask | 1, usedDigits);
                } else {
                    ans += helper(s, index + 1, tight && (dig == ub), mask, usedDigits); // else don't
                }
            } else {
                Set<Integer> newUsedDigits = new HashSet<>(usedDigits);
                newUsedDigits.add(dig); // mark visited and fill for next
                ans += helper(s, index + 1, tight && (dig == ub), mask | (1 << dig), newUsedDigits);
            }
        }

        return dp[index][tight ? 1 : 0][mask] = ans;
    }

    public static int countSpecialNumbers(int n) {
        String s = Integer.toString(n);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < (1 << 10); k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return (int) (helper(s, 0, true, 0, new HashSet<>()) - 1); // - for removing zero as the question wants from [1,n];
    }

  
}


public class Solution {
    static long[][][] dp = new long[20][2][1 << 10];

    public static long helper(String s, int index, boolean tight, int mask) {
        if (index == s.length()) {
            return 1;
        }

        if (dp[index][tight ? 1 : 0][mask] != -1) return dp[index][tight ? 1 : 0][mask];

        int ub = tight ? s.charAt(index) - '0' : 9;
        long ans = 0;

        for (int dig = 0; dig <= ub; dig++) {
            if (((mask >> dig) & 1) == 1) continue;
            if (dig == 0) {
                if (mask != 0) ans += helper(s, index + 1, tight && (dig == ub), mask | 1);
                else ans += helper(s, index + 1, tight && (dig == ub), mask);
            } else {
                ans += helper(s, index + 1, tight && (dig == ub), mask | (1 << dig));
            }
        }

        return dp[index][tight ? 1 : 0][mask] = ans;
    }

    public static int countSpecialNumbers(int n) {
        String s = Integer.toString(n);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < (1 << 10); k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return (int) (helper(s, 0, true, 0) - 1);
    }
}
