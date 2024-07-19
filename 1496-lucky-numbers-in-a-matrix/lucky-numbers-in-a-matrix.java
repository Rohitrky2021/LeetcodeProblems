import java.util.*;

class Solution {
    public List<Integer> luckyNumbers(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        List<Integer> luckyNumbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minCol = -1;
            for (int j = 0; j < m; j++) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                    minCol = j;
                }
            }

            boolean isLucky = true;
            for (int k = 0; k < n; k++) {
                if (arr[k][minCol] > min) {
                    isLucky = false;
                    break;
                }
            }

            if (isLucky) {
                luckyNumbers.add(min);
            }
        }

        return luckyNumbers;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
            {3, 7, 8},
            {9, 11, 13},
            {15, 16, 17}
        };
        List<Integer> result = solution.luckyNumbers(arr);
        System.out.println(result); // Output should be [15]
    }
}
