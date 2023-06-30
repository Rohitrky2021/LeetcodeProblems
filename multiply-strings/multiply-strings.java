
class Solution {
    public String multiply(String num1, String num2) {
        // String op="";
        // // long a=naxtLong(num1);
        // long a = Long.parseLong(num1);
        
        

        // long b = Long.parseLong(num2);

        // // long b=Integer.parseInt(num2);

        // long ans=a*b;
        
        

        // // op.concat("ans");
        // op=""+ans;
        // return op;

        return multiplyStrings(num1,num2);


    }
    public static String multiplyStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] product = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                int temp = digit1 * digit2 + product[i + j + 1];
                product[i + j + 1] = temp % 10;
                product[i + j] += temp / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int digit : product) {
            if (!(sb.length() == 0 && digit == 0)) {
                sb.append(digit);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
          

}