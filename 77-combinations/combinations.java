import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> l = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> hs = new HashSet<>();

        combineHelper(n, k, 1, l, ans, hs);
        return ans;
    }

    private void combineHelper(int n, int k, int start, List<Integer> current,List<List<Integer>> ans,             HashSet<List<Integer>> hs) {
        if (current.size() == k) {
            List<Integer> combination = new ArrayList<>(current); // Create a copy of the current list
            // if (!hs.contains(combination)) {
                hs.add(combination);
                ans.add(combination);
            // }
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            combineHelper(n, k, i + 1, current, ans, hs); // Recursively generate combinations
            current.remove(current.size() - 1); // Backtrack by removing the last element
        }
    }
}
