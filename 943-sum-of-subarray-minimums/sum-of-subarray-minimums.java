class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        // Stack to store pairs of (value, count) for left traversal
        Stack<Pair> s1 = new Stack<>();
        // Stack to store pairs of (value, count) for right traversal
        Stack<Pair> s2 = new Stack<>();
        
        // Calculate the number of elements greater than arr[i] on the left
        for (int i = 0; i < n; i++) {
            int count = 1;
            
            // Pop elements from stack until finding an element greater than arr[i]
            while (!s1.isEmpty() && s1.peek().value > arr[i]) {
                count += s1.peek().count;
                s1.pop();
            }
            
            s1.push(new Pair(arr[i], count));
            left[i] = count;  // Store the count in the left array
        }
        
        // Calculate the number of elements greater than or equal to arr[i] on the right
        for (int i = n - 1; i >= 0; i--) {
            int count = 1;
            
            // Pop elements from stack until finding an element greater or equal to arr[i]
            while (!s2.isEmpty() && s2.peek().value >= arr[i]) {
                count += s2.peek().count;
                s2.pop();
            }
            
            s2.push(new Pair(arr[i], count));
            right[i] = count;  // Store the count in the right array
        }
        
        // Use long to handle the large sum
        long result = 0;
        int mod = 1_000_000_007; // To prevent overflow and ensure the result is within the integer range
        for (int i = 0; i < n; i++) {
            result = (result + (long)arr[i] * left[i] * right[i]) % mod;
        }
        
        return (int) result;  // Cast result to int before returning
    }
    
    // Helper class to store pairs of value and count
    private static class Pair {
        int value, count;
        public Pair(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}
