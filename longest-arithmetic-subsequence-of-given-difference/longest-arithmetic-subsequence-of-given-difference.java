class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int longestSequence = 1;

        for (int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i] - difference, 0) + 1);       
            longestSequence = Math.max(longestSequence, map.get(arr[i]));
        }
        return longestSequence;
    }
}