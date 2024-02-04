class Solution {
    public int minLength(String s) {
        Stack st = new Stack();
        for(char c: s.toCharArray()){
            if(!st.isEmpty() && (((char)st.peek() == 'A' && c == 'B') || ((char)st.peek() == 'C' && c == 'D'))) st.pop();
            else    st.push(c);
        }
        return st.size();
    }
}