class Solution {
    public String losingPlayer(int x, int y) {
        // Each turn requires 1 coin of 75 value and 4 coins of 10 value
        // Check if we have enough 75-value coins and 10-value coins to make at least one move
        if (x * 75 + y * 10 < 115) {
            return "Bob"; // If they cannot make even one move, Alice loses immediately
        }

        // Count the number of full turns possible
        int turns = 0;
        while (x > 0 && y >= 4) {
            x -= 1;
            y -= 4;
            turns++;
        }

        // Determine the winner based on the number of full turns
        if (turns % 2 == 1) {
            return "Alice";
        } else {
            return "Bob";
        }
    }
}
