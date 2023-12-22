class Solution {
    public int maxScore(String s) {
        char ans[] = s.toCharArray();
        int c = 0, max = Integer.MIN_VALUE;

        // Count the number of 1s in the entire string
        for (int i = ans.length - 1; i >= 0; i--) {
            if (ans[i] == '1') {
                c++;
            }
        }

        int zerosCount = 0;
        for (int i = 0; i < ans.length - 1; i++) {
            if (ans[i] == '0') {
                zerosCount++;
            }
            
            // Calculate the score for each split and find the maximum score
            max = Math.max(max, c - (i + 1 - zerosCount) + zerosCount);
        }

        return max;
    }
}


class Solution1 {
    public int maxScore(String s) {
        int n = s.length();
        int[] countOnesRight = new int[n];
        int[] countZerosLeft = new int[n];

        // Count the number of 1s on the right for each position
        int onesCount = 0;
        for (int i = n - 1; i >= 0; i--) {
            countOnesRight[i] = onesCount;
            if (s.charAt(i) == '1') {
                onesCount++;
            }
        }

        // Count the number of 0s on the left for each position
        int zerosCount = 0;
        for (int i = 0; i < n; i++) {
            countZerosLeft[i] = zerosCount;
            if (s.charAt(i) == '0') {
                zerosCount++;
            }
        }

        // Calculate the score for each split and find the maximum score
        int maxScore = 0;
        for (int i = 0; i < n - 1; i++) {
            int score = countZerosLeft[i] + countOnesRight[i];
            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }
}
