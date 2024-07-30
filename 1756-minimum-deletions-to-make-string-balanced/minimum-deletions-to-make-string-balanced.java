// https://www.geeksforgeeks.org/make-all-ones-together-by-shifting-ones/
// https://www.geeksforgeeks.org/minimum-flips-to-make-all-1s-in-right-and-0s-in-left/
// https://leetcode.com/problems/move-zeroes/

class Solution {
    public int minimumDeletions(String s) {
        int res = 0, count = 0;
        for (char c : s.toCharArray()){
            if (c == 'b')
                count++;
            else if (count != 0){
                res++;
                count--;
            }
        }
        return res;
    }
}