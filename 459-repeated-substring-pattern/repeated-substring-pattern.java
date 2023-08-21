class Solution {
    public static boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        String str1 = str.substring(1, str.length() - 1);//removing first ans last
        // upper step ensure thatt pattern hmara inner se check hoga means will get it only if exist after repeatin it 
        return str1.contains(s);
    }
}