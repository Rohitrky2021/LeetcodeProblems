class Solution1 {

    int check=0;
    public String getPermutation(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        check=k;
        int nums[]=new int[n];
        for(int i=1;i<=n;i++){
            nums[i-1]=i;
        }

        ans=permute(nums);

        String st="";

        for(int x:ans.get(k-1)){
            st+=x;
        }

        return st ;

    }

    public  List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, current, result);
        return result;
    }


    private void backtrack(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> result) {

        if(result.size()>check)return;   // After this line Optimisation the previous code worked 

        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            //  if (visited[i]) {
            //     continue;
            //     // ---------------->when revise ones uncomment and run this !
            // }
            visited[i] = true;
            current.add(nums[i]);
            backtrack(nums, visited, current, result);
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}
 
class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> nums = new ArrayList<>();
        
        // Initialize nums list with numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        
        // Compute factorial of n
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        
        // Adjust k to start from 0
        k--;
        
        // Construct the k-th permutation
        for (int i = 0; i < n; i++) {
            factorial /= (n - i);
            int index = k / factorial;
            sb.append(nums.get(index));
            nums.remove(index);
            k -= index * factorial;
        }
        
        return sb.toString();
    }
}
