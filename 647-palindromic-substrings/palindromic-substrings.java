class Solution1 {
    public int countSubstrings(String s) {
        char arr[]=s.toCharArray();
       int count=0;


        for(int i=1;i<arr.length-1;i++){
           int len= expand(i,arr);
            count+=len;
        }

        return count;
    }


  public int expand(int i,char s[]){
        int j=i,j1=i+1;
        int c=0;
        while(s[i]==s[j] && i>0 && j<s.length ){
            i--;
            j++;
            c++;
        }
        i=j1-1;
      while(s[i]==s[j1] && i>0 && j1<s.length ){
            i--;
            j1++;
            c++;
        }

        return c;


    }
}


class Solution2 {
    int count;

    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += expand(i, arr);
        }

        return count;
    }

    public int expand(int i, char[] s) {
        int j = i, j1 = i + 1;
        int c = 0;

        while (i >= 0 && j < s.length && s[i] == s[j]) {
            i--;
            j++;
            c++;
        }

        i = j1 - 1;
        while (i >= 0 && j1 < s.length && s[i] == s[j1]) {
            i--;
            j1++;
            c++;
        }

        return c;
    }
}

class Solution3 {
    public int countSubstrings(String s) {
        int count = 0;

        // Initialize a lookup table of dimensions len(s) * len(s)
        boolean[][] dp = new boolean[s.length()][s.length()];

        // Base case: A string with one letter is always a palindrome
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            count++;
        }

        // Base case: Substrings of two letters
        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            count += dp[i][i + 1] ? 1 : 0;
        }

        // Substrings of lengths greater than 2
        for (int length = 3; length <= s.length(); length++) {
            for (int i = 0, j = length - 1; j < s.length(); i++, j++) {
                dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                count += dp[i][j] ? 1 : 0;
            }
        }

        return count;
    }
}

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] palindrome = new boolean[n][n];
        int ans = 0;

        for(int len=1;len<=n;len++) {
            for(int i=0;i<n-len+1;i++) {
                if(s.charAt(i) == s.charAt(i+len-1) 
                    && (len <= 2 || palindrome[i+1][i+len-2])) {
                    palindrome[i][i+len-1] = true;
                    ans++;
                }
            }
        }

        return ans;
    }
}