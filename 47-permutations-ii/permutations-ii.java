// class Solution {
//     public List<List<Integer>> permuteUnique(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();
//         List<Integer> current = new ArrayList<>();
//         boolean[] visited = new boolean[nums.length];
//         backtrack(nums, visited, current, result);
//         return result;
//     }

//         private void backtrack(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> result) {
//         if (current.size() == nums.length) {
//             if(!result.contains(current)) result.add(new ArrayList<>(current)); // THe Line we CHange to Solve All same 
//             return;
//         }

//         for (int i = 0; i < nums.length; i++) {

//              if (visited[i]) {
//                 continue; // ---------------->when revise ones comment and run this Line !
//             }
//             visited[i] = true;
//             current.add(nums[i]);
//             backtrack(nums, visited, current, result);
//             current.remove(current.size() - 1);
//             visited[i] = false;
//         }
//     }
// }

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums); // Sort the input array to handle duplicates --> This take Same nearby 
        backtrack(nums, visited, current, result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // Add the permutation directly without checking for duplicates
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue; // Skip duplicates
            }
            visited[i] = true;
            current.add(nums[i]);
            backtrack(nums, visited, current, result);
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}


