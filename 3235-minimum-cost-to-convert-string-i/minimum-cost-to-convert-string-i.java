import java.util.*;

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        // Initialize a distance matrix for Floyd-Warshall
        long[][] dist = new long[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0; // cost to stay the same is 0
        }
        
        // Populate direct edges
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            if (dist[u][v] > cost[i]) {
                dist[u][v] = cost[i];
            }
        }
        
        // Floyd-Warshall to find all pairs shortest paths
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            char sChar = source.charAt(i);
            char tChar = target.charAt(i);
            if (sChar == tChar) {
                continue;
            }
            int u = sChar - 'a';
            int v = tChar - 'a';
            if (dist[u][v] == Integer.MAX_VALUE) {
                return -1;
            }
            totalCost += dist[u][v];
        }
        
        return totalCost;
    }
}