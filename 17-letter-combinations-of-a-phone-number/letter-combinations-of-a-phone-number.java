import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new  ArrayList<String>();
        }
        String comb = "";
        return printcomb(digits, 0, comb);
    }

    public List<String> printcomb(String digi, int idx, String comb) {
        List<String> ans = new ArrayList<String>();
        

        // Base case: add the current combination to the result list
        if (comb.length() == digi.length()) {
            ans.add(comb);
            return ans; // Return the result at this point
        }

        String[] keypad = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char curr = digi.charAt(idx);

        // --->converting char to int ;
        String map = keypad[curr - '0'-2];

        for (int i = 0; i < map.length(); i++) {
            ans.addAll(printcomb(digi, idx + 1, comb + map.charAt(i))); // Combine the lists
        }
        return ans;
    }
}
