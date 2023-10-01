class Solution {

    public String reverseWords(String s) {
       StringBuilder ss=new StringBuilder();
        String ar[]=s.split(" ");
      

        for(String  i:ar){
            StringBuilder m=new StringBuilder(i);
            ss.append(m.reverse()+" ");

        }
          return  ss.toString().trim();
    }
}
