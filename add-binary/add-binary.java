class Solution {
    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder("");

        int i=a.length()-1, j=b.length()-1;
        int sum = 0;
        int carry = 0;
        while(i>=0 || j>=0 ||  carry != 0){
            int x = i>=0 ? Integer.valueOf(a.charAt(i--)-'0') : 0;
            int y = j>=0 ? Integer.valueOf(b.charAt(j--)-'0') : 0;

            sum = x + y + carry;
            // System.out.println("In loop : "+sum);

            carry = 0;
            if(sum == 0){
                str.append("0");
            }else if(sum == 1){
                str.append("1");
            }else if(sum == 2){
                str.append("0");
                carry = 1;
            }else if(sum == 3){
                str.append("1");
                carry = 1;
            }
        }
        return str.reverse().toString();
    }
}

class Solution {
    public String addBinary(String A, String B) {
          int i = A.length()-1;
        // initialize the jth index
        int j = B.length()-1;
        // initialize the carry
        int carry = 0;
      // initialize the sum
        int sum = 0;
        StringBuilder result =  new StringBuilder();
        while(i>=0 || j>=0 || carry == 1){
            sum = carry;
            if(i>=0) sum = sum+A.charAt(i)-'0';
            if(j>=0) sum = sum+B.charAt(j)-'0';
            result.append((char)(sum%2+'0'));
            carry = sum/2;
            i--;
            j--;
        }
        return result.reverse().toString();
    }
}
