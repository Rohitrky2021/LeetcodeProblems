public class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0; // Base case: The 1st row always contains 0.
        }

        int mid = (int) Math.pow(2, n - 1) / 2;
        
        if (k <= mid) {
            return kthGrammar(n - 1, k); // Recurse on the previous row.
        } else {
            return 1 - kthGrammar(n - 1, k - mid); // Recurse on the previous row with flipped bits.
        }
    }
}


class Solution2 {

    public int kthGrammar(int n, int k) {
    return kthNumber(n, k+1);
}

public int kthNumber(int n, int k) {
    int result = 0;
    int bit = 0;

    while (n > 0) {
        // Calculate the number of binary digits that can be generated at this level.
        int numDigits = (1 << n) - 1;

        if (k == numDigits / 2) {
            // If k is in the middle, the current bit is 1.
            result |= (1 << bit);
            break;
        } else if (k > numDigits / 2) {
            // If k is in the right half, the current bit is 1, and we reduce k.
            result |= (1 << bit);
            k = numDigits - k;
        }

        // Move to the next level and continue.
        n--;
        bit++;
    }

    return result;
}
}
