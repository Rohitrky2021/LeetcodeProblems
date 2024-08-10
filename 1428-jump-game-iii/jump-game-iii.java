class Solution1 {
    public boolean canReach(int[] arr, int start) {
        // Base cases
        if (start < 0 || start >= arr.length || arr[start] < 0) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        
        // Mark as visited by making the current element negative-> Loop m na phas jaaye esliye
        arr[start] = -arr[start];

        // Recursive checks for both possible directions
        boolean canReachLeft = canReach(arr, start - arr[start]);
        boolean canReachRight = canReach(arr, start + arr[start]);

        return canReachLeft || canReachRight;
    }
}

class Solution {
    public boolean canReach(int[] arr, int start) {
        Boolean[] dp = new Boolean[arr.length]; // DP array initialized to null
        return canReachHelper(arr, start, dp);
    }

    private boolean canReachHelper(int[] arr, int start, Boolean[] dp) {
        // Base cases
        if (start < 0 || start >= arr.length || arr[start] < 0) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        if (dp[start] != null) {
            return dp[start]; // Return the cached result if already computed
        }

        // Mark as visited by making the current element negative
        arr[start] = -arr[start];

        // Recursive checks for both possible directions
        boolean canReachLeft = canReachHelper(arr, start - arr[start], dp);
        boolean canReachRight = canReachHelper(arr, start + arr[start], dp);

        // Store the result in the DP array
        dp[start] = canReachLeft || canReachRight;

        return dp[start];
    }
}
