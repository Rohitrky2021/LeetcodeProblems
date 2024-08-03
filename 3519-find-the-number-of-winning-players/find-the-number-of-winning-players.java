import java.util.Arrays;

class Solution1 {
    public int winningPlayerCount(int n, int[][] pick) {
        // Sort the 2D array with a comparator
        Arrays.sort(pick, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

        int ans[][] = new int[105][13];
        int freq[] = new int[105];
        int count = 0;

        for (int[] x : pick) {
            ans[x[0]][x[1]]++;

            if (ans[x[0]][x[1]] > x[0]) {
                freq[x[0]]++;
            }
        }

        for (int x : freq) {
            if (x != 0) count++;
        }

        return count;
    }
}
 
class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        // Array to keep track of the counts of each color picked by each player
        Map<Integer, Integer>[] playerPicks = new HashMap[n];
        
        // Initialize the array with HashMaps
        for (int i = 0; i < n; i++) {
            playerPicks[i] = new HashMap<>();
        }

        // Fill the array with the picks data
        for (int[] p : pick) {
            int player = p[0];
            int color = p[1];
            playerPicks[player].put(color, playerPicks[player].getOrDefault(color, 0) + 1);
        }

        // Count the number of winners
        int winners = 0;
        for (int i = 0; i < n; i++) {
            for (int count : playerPicks[i].values()) {
                if (count > i) {
                    winners++;
                    break; // No need to check further for this player
                }
            }
        }

        return winners;
    }

   
}
