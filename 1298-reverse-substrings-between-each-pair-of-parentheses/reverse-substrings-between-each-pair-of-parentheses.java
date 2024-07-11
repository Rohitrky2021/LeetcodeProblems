// class Solution2 {
//     public String reverseParentheses(String s) {
//         Stack<Character> st=new LinkedList<>();


//         int ans ="";

//         for(char c:s.toCharArray()){
//             if(c!=')'){
//                 st.push(c);
//             }else{
//                 String toreverse="";
//                 while(st.isempty() || st.peek()!='('){
//                         toreverse+=st.pop();
//                 }
//                 for(char d:toreverse.toCharArray()){
//                     st.push(d);
//                 }
//             }
//         }

//        for(char c:st){
//         ans+=c;
//        }


//         return ans;
        
//     }
// }

 
class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c != ')') {
                st.push(c);
            } else {
                StringBuilder toReverse = new StringBuilder();
                while (!st.isEmpty() && st.peek() != '(') {
                    toReverse.append(st.pop());
                }
                st.pop(); // pop the '('
                for (char d : toReverse.toString().toCharArray()) {
                    st.push(d);
                }
            }
        }

        for (char c : st) {
            ans.append(c);
        }

        return ans.toString();
    }
}
