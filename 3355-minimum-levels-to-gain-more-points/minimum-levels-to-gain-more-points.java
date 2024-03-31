class Solution {
    public int minimumLevels(int[] possible) {
        int n = possible.length;
        
        int totalSum = 0;
        for(int i = 0; i < n; i++) {
            if(possible[i] == 0) possible[i] = -1; // Convert 0s to -1s to represent levels that cannot be cleared
            totalSum += possible[i]; // Calculate the total sum of possible levels
        }
        
        int currScore = 0; // Initialize the current score
        for(int i = 0; i < n - 1; i++) {
            currScore += possible[i]; // Accumulate the score as Danielchandg plays each level
            // If the remaining levels for Bob cannot give him more points than Danielchandg,
            // return the current level Danielchandg should play to have more points
            if(totalSum - currScore < currScore) return i + 1;
        }
        
        return -1; // If it's not possible for Danielchandg to gain more points, return -1
    }
}
