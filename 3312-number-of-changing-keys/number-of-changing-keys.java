class Solution {
    public int countKeyChanges(String s) {
        s = s.toLowerCase();
        char[] arr = s.toCharArray();
        int c = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (arr[i] != arr[i + 1]) // Fixed to access char array 'arr' instead of string 's'
                c++;
        }

        return c;
    }
}
