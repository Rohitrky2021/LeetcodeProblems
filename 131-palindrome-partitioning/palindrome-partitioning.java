class Solution {

    public List<List<String>> partition(String s) {
        List<String> path = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        helper(0, s, ans, path);

        return ans;
    }
    
    public  void helper(int idx, String s, List<List<String>> ans, List<String> path) {

        if (idx == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (ispalindrome(s, idx, i)) {
                path.add(s.substring(idx, i + 1));
                helper(i + 1, s, ans, path);
                path.remove(path.size() - 1);
            }
        }

    }

   public  boolean ispalindrome(String a, int st, int end) {
        while (st < end) {
            System.out.println(st);
            if (a.charAt(st++) != a.charAt(end--)) {
                return false;

            }
        }
        return true;
    }


}
