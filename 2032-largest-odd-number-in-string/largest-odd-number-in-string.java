class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        char[] arr = num.toCharArray();
        int i;
        for (i = n - 1; i >= 0; i--) {
            if (arr[i] % 2 != 0)
               return num.substring(0, i + 1);
        }

        
            return "";

        
    }
}
