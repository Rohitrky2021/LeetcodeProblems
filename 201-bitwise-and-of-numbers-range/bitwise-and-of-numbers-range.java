
// Approach 1
// Description: Iterate through the range [left, right]. This approach will give Time Limit Exceeded (TLE) for large ranges.
// Time Complexity: O(right - left)
// Space Complexity: O(1)

// Approach 2
// Description: Shift both left and right to the right until >> left == right <<< , while counting how many times you shifted.
// Time Complexity: O(log2(left) + log2(right))
// Space Complexity: O(1)

class Solution1 {
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        
        // Find the common leftmost bits of m and n
        while (m < n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }
        
        // Left shift back to obtain the result
        return m << shift;
    }
}


// Approach 3

// Description: Set the rightmost 1 bit of right to 0 until left >= right.
// Time Complexity: O(popcount(right))
// Space Complexity: O(1)
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right &= (right - 1); // Set the rightmost 1 bit of right to 0
        }
        return right;
    }
}
