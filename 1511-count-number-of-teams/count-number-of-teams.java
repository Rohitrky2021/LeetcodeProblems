class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int ans = 0;

        // Create a TreeMap to store the indices of the ratings
        TreeMap<Integer, Integer> indexMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(rating[i], i);
        }

        // Iterate through the ratings array
        for (int i = 0; i < n; i++) {
            int currRating = rating[i];

            // Find the number of ratings to the left and right that are smaller and larger
            int leftSmaller = 0, leftLarger = 0;
            int rightSmaller = 0, rightLarger = 0;

            // Iterate through the indices to the left of i
            for (int j = 0; j < i; j++) {
                if (rating[j] < currRating) leftSmaller++;
                else if (rating[j] > currRating) leftLarger++;
            }

            // Iterate through the indices to the right of i
            for (int j = i + 1; j < n; j++) {
                if (rating[j] < currRating) rightSmaller++;
                else if (rating[j] > currRating) rightLarger++;
            }

            // Update the answer
            ans += leftSmaller * rightLarger + leftLarger * rightSmaller;
        }

        return ans;
    }
}