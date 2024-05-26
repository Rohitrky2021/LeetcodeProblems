class Solution1 {
    public boolean checkRecord(String s) {

        char last = '@';
        char curr;
        int ca = 0, maxl = 0, l = 0;

        for (char x : s.toCharArray()) {
            curr = x;
            if (x == 'A') ca++;

            if (curr == 'L') l++;
            else if (curr != 'L') l = 0;
            last = curr;

            maxl = Math.max(maxl, l);
        }

        return ca < 2 && maxl < 3;
    }
}

class Solution {
    public boolean checkRecord(String s) {

        char[] mn=s.toCharArray();
        boolean flag=true;
        int ca=0;
        if(mn[0]=='A')ca++;
        if(s.length()==1)return true;
        if(s.length()==2 && ca!=0 && mn[1]=='A')return false;
        for(int i=1;i<mn.length-1;i++){
            if(mn[i]=='L' &&  mn[i-1]=='L' &&  mn[i+1]=='L')flag=false;
            if (mn[i] == 'A') ca++;
        }
        if(mn[s.length()-1]=='A')ca++;

        return flag && ca<2;

    }
}
