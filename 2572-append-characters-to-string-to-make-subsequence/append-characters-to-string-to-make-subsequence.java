class Solution {
    public int appendCharacters(String s, String t) {
        char chS[] = s.toCharArray();
        char chT[] = t.toCharArray();

        int i = 0, j = 0;
        int m = chS.length, n = chT.length;
        for(; i < m; i++)
        {
            if(chS[i] == chT[j])
                j++;
            
            if(j == n)
                break;
        }
        return n - j;
        
    }
}