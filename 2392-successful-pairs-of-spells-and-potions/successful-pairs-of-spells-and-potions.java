import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int np = potions.length;
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            long threshold = (success + spells[i] - 1) / spells[i]; // Ceil(success / spells[i])
            int index = binarySearch(potions, threshold);
            spells[i] = np - index; // Modifying spells directly
        }

        return spells;
    }

    private int binarySearch(int[] potions, long target) {
        int left = 0, right = potions.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left; // First index where potions[index] >= target
    }
}
