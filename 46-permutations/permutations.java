// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();
//         List<Integer> current = new ArrayList<>();
//         boolean[] visited = new boolean[nums.length];
//         backtrack(nums, visited, current, result);
//         return result;
//     }

//     private void backtrack(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> result) {
//         if (current.size() == nums.length) {
//             result.add(new ArrayList<>(current));
//             return;
//         }

//         for (int i = 0; i < nums.length; i++) {
//             if (visited[i]) {
//                 continue;
//             }
//             //  if (visited[i]) {
//             //     continue;
//             //     // ---------------->when revise ones uncomment and run this !
//             // }
//             visited[i] = true;
//             current.add(nums[i]);
//             backtrack(nums, visited, current, result);
//             current.remove(current.size() - 1);
//             visited[i] = false;
//         }
//     }
// }

// M2
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(nums, 0, current, result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        if (start == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i); // Swap elements to generate permutations
            current.add(nums[start]);
            backtrack(nums, start + 1, current, result);
            current.remove(current.size() - 1);
            swap(nums, start, i); // Swap back to backtrack properly
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


