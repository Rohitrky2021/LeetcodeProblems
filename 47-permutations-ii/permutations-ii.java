class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
         List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, current, result);
        return result;
    }

        private void backtrack(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            if(!result.contains(current)) result.add(new ArrayList<>(current)); // Te
            return;
        }

        for (int i = 0; i < nums.length; i++) {

             if (visited[i]) {
                continue; // ---------------->when revise ones comment and run this Line !
            }
            visited[i] = true;
            current.add(nums[i]);
            backtrack(nums, visited, current, result);
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}


