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


class Solution {
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
