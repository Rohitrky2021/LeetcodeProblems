class Solution1 {

    // M1-> Brute Force
    public int findMaximumXOR(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                max = Math.max(max, A[i] ^ A[j]);
            }
        }
        System.gc();
        return max;
    }
}

// M 2--> Using Trie->
class Solution {

    public int findMaximumXOR(int[] A) {
        int ans = 0;

        int mask = 0;
        int n = A.length;

        for (int i = 30; i >= 0; i--) {
            HashSet<Integer> s = new HashSet<>();

            // Setting the ith bit 1 in mask.
            mask = mask | (1 << i);

            for (int j = 0; j < n; j++) {
                // Inserting prefix bitmask into the set.
                s.add(A[j] & mask);
            }

            int tempAns = ans;

            // Setting the ith bit 1.
            tempAns = tempAns | (1 << i);

            for (Integer it : s) {
                // Checking if 'it' xor 'tempAns' is present in set.
                if (s.contains(it ^ tempAns)) {
                    ans = tempAns;
                    break;
                }
            }
        }

        return ans;
    }

}
