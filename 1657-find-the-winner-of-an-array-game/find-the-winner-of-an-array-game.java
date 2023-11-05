
class Solution1 {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int max = Math.max(arr[0], arr[1]);
        int consecutiveWins = 1;

        for (int i = 2; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                consecutiveWins = 1;
            } else {
                consecutiveWins++;
            }

            if (consecutiveWins == k || consecutiveWins == n) {
                return max;
            }
        }

        return max;
    }
}

class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int consecutiveWins = 0;
        int currentWinner = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > currentWinner) {
                currentWinner = arr[i];
                consecutiveWins = 1;
            } else {
                consecutiveWins++;
            }

            if (consecutiveWins == k) {
                return currentWinner;
            }
        }

        // If no winner found after going through the entire array,
        // the winner is the maximum value in the array.
        return currentWinner;
    }
}


class Solutionf {
    public HashMap<Integer, Integer> digitFrequency = new HashMap<>();

    public int getWinner(int[] arr, int k) {
        int n = arr.length;
     
        int maxi = Integer.MIN_VALUE;
        int max = Math.max(arr[0], arr[1]);
        digitFrequency.put(max, digitFrequency.getOrDefault(max, 0) + 1);
        int i=0;
        
        for (int x : arr) {
           digitFrequency.put(x, digitFrequency.getOrDefault(x, 0) + 1);
        }
        for (  i = 2; i < n; i++) {
            maxi = Math.max(max, arr[i]);
            if (maxi == max){ digitFrequency.put(maxi, digitFrequency.getOrDefault(maxi, 0) + 1);}
            else{
                digitFrequency.put(max, digitFrequency.getOrDefault(maxi, 0) + 1);
            }
            max=maxi;

            if (digitFrequency.getOrDefault(maxi, 0) == k) break;
        }

        if(digitFrequency.getOrDefault(maxi, 0) != k) return maxi;

        int ans = 0;


        return arr[i-1];
    }
}
