class Solution {
                    // This not worked 
    public int minimumLevels(int[] possible) {
        int n = possible.length;

        // Count the total number of possible levels
        int totalPossibleLevels = 0;
        for(int i = 0; i < n; i++) {
            if(possible[i] == 0) possible[i] = -1; // Convert 0s to -1s to represent levels that cannot be cleared
            totalPossibleLevels += possible[i]; // Calculate the total sum of possible levels
        }

        // Initialize variables to keep track of Danielchandg's points and Bob's points
        int danielPoints = 0;

        // Loop through all possible levels that Danielchandg can play
        for (int i = 0; i < n - 1; i++) {
            if (possible[i] == 1) {
                // Danielchandg plays level i
                danielPoints++;
                // Bob plays the remaining levels
                int bobPoints = totalPossibleLevels - danielPoints;
                // Calculate the difference in points between Danielchandg and Bob
                int diff = danielPoints - bobPoints;
                // If Danielchandg has more points, return the current level
                if (bobPoints < danielPoints) {
                    return i + 1;
                }
            } else {
                // Danielchandg fails to clear level i, decrement danielPoints
                danielPoints--;
                int bobPoints = totalPossibleLevels - danielPoints;
                      if (bobPoints < danielPoints) {
                    return i + 1;
                }
                // If Danielchandg's points become negative, it's not possible to win
              
            }
        }

        // If it's impossible for Danielchandg to gain more points, return -1
        return -1;
    }
}



class Solution1 {
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