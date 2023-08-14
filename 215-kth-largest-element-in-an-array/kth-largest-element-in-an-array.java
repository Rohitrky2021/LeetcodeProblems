class Solution {

    public int findKthLargest(int[] arr, int k) {
        int n=arr.length;
        k = n - k + 1;

        int minVal = Arrays.stream(arr).min().getAsInt();
        // First, find the maximum element in the array
        int max_element = Arrays.stream(arr).max().getAsInt();

        int rangeSize = max_element - minVal + 1;
        int[] Modified = Arrays.stream(arr).map(num -> num - minVal).toArray();
        int[] freq = new int[rangeSize];

        // Create an array to store the frequency of each
        // element in the input array
        // int[] freq = new int[max_element + 1];
        Arrays.fill(freq, 0);
        for (int i = 0; i < n; i++) {
            freq[Modified[i]]++;
        }

        // Keep track of the cumulative frequency of
        // elements in the input array
        int count = 0;
        for (int i = 0; i <= rangeSize; i++) {
            if (freq[i] != 0) {
                count += freq[i];
                if (count >= k) {
                    // If we have seen k or more elements,
                    // return the current element
                    return i + minVal;
                }
            }
        }
        return -1;
    }
}
