class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> currentCombination = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        backtrack(1, n, k, currentCombination, ans);
        
        return ans;
    }
    
    private void backtrack(int start, int n, int k, List<Integer> currentCombination, List<List<Integer>> ans) {
        if (currentCombination.size() == k) {
            ans.add(new ArrayList<>(currentCombination));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            currentCombination.add(i);
            backtrack(i + 1, n, k, currentCombination, ans);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
