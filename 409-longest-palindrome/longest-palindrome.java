class Solution2 {
    public int longestPalindrome(String st) {
        int[] frequency = new int[70]; // Assuming ASCII characters

        for (char c : st.toCharArray()) {
            System.out.println((int)c);
            frequency[c-'A']++;
        }

        int evenCount = 0;
        int oddCount = 0;

        for (int freq : frequency) {
            evenCount += freq / 2;
            oddCount += freq % 2;
        }

        return 2 * evenCount + (oddCount > 0 ? 1 : 0);
    }
}


class Solution {
    public int longestPalindrome(String st) {
        int[] frequency = new int[128]; // Assuming ASCII characters

        for (char c : st.toCharArray()) {
            frequency[c]++;
        }

        int evenCount = 0;
        int oddCount = 0;

        for (int freq : frequency) {
            evenCount += freq / 2;
            oddCount += freq % 2;
        }

        return 2 * evenCount + (oddCount > 0 ? 1 : 0);
    }
}