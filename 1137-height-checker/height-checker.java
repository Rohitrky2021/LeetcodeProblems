import java.util.Arrays;

class Solution {
    public int heightChecker(int[] ht) {
        // Create a copy of the ht array
        int check[] = Arrays.copyOf(ht, ht.length);
        
        // Sort the copied array
        Arrays.sort(check);
        
        int n = ht.length;
        int count = 0;

        // Compare each element of the original and sorted arrays
        for (int i = 0; i < n; i++) {
            if (ht[i] != check[i]) {
                count++;
            }
        }
        
        // Return the count of differing elements
        return count;
    }
}
