#include <vector>
#include <string>
#include <algorithm>
using namespace std;

class Solution {
private:
    string num;
    vector<vector<vector<int>>> dp;
    int backtrack(int curr, bool isUpper, bool prevIsOne) {
        if (curr == num.length())
            return 1;
        if (dp[curr][isUpper][prevIsOne] != -1)
            return dp[curr][isUpper][prevIsOne];
        int lo = 0, hi = isUpper ? num[curr] - '0' : 1;
        int ans = 0;
        for (int i = lo; i <= hi; i++) {
            if (prevIsOne && i == 1)
                continue;
            ans += backtrack(curr + 1, isUpper && i == hi, i == 1);
        }
        return dp[curr][isUpper][prevIsOne] = ans;
    }
public:
    int findIntegers(int n) {
        dp.resize(30, vector<vector<int>>(2, vector<int>(2, -1)));
        while (n > 0) {
            num.push_back(static_cast<char>((n % 2) + '0'));
            n /= 2;
        }
        reverse(num.begin(), num.end());
        return backtrack(0, true, false);
    }
};
