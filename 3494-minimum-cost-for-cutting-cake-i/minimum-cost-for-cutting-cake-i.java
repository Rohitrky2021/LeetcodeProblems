import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        // Sorting the costs in descending order
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        
        int h = horizontalCut.length - 1;
        int v = verticalCut.length - 1;
        
        // Start with one horizontal piece and one vertical piece
        int hp = 1, vp = 1;
        int cost = 0;
        
        // While there are cuts to be made
        while (h >= 0 && v >= 0) {
            // If the current horizontal cut is more expensive or equal to the current vertical cut
            if (horizontalCut[h] >= verticalCut[v]) {
                cost += horizontalCut[h] * vp;
                hp++;
                h--;
            } else { // If the current vertical cut is more expensive
                cost += verticalCut[v] * hp;
                vp++;
                v--;
            }
        }
        
        // If there are remaining horizontal cuts
        while (h >= 0) {
            cost += horizontalCut[h] * vp;
            hp++;
            h--;
        }
        
        // If there are remaining vertical cuts
        while (v >= 0) {
            cost += verticalCut[v] * hp;
            vp++;
            v--;
        }
        
        return cost;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int m1 = 3, n1 = 2;
        int[] horizontalCut1 = {1, 3};
        int[] verticalCut1 = {5};
        System.out.println(solution.minimumCost(m1, n1, horizontalCut1, verticalCut1)); // Output: 13
        
        int m2 = 2, n2 = 2;
        int[] horizontalCut2 = {7};
        int[] verticalCut2 = {4};
        System.out.println(solution.minimumCost(m2, n2, horizontalCut2, verticalCut2)); // Output: 15
    }
}
