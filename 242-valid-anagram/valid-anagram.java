class Solution {

    public boolean isAnagram(String s1, String s2) {
        // Convert strings to char arrays
        char[] c1 = s1.toLowerCase().toCharArray();
        char[] c2 = s2.toLowerCase().toCharArray();

        // Sort the char arrays
        Arrays.sort(c1);
        Arrays.sort(c2);

        // Compare the sorted char arrays
        return Arrays.equals(c1, c2);
    }
}
