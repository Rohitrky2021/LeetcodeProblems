class Solution {

    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        // int n=k;
        int c[]=new int[9];
        for(int i=1;i<=9;i++){
            c[i-1]=i;
        }
        // Arrays.sort(c);
        combination2(0, c, target, res, list,k);
        return res;
    }

    // public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    //     List<List<Integer>> res = new ArrayList<List<Integer>>();
    //     List<Integer> list = new ArrayList<>();
    //     Arrays.sort(candidates);
    //     combination2(0, candidates, target, res, list);
    //     return res;
    // }

    public void combination2(int index, int[] arr, int target, List<List<Integer>> res, List<Integer> list,int k) {
        if (target == 0 && list.size()==k) {
            Collections.sort(list);
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue;
            if (target < arr[i]) break;

            list.add(arr[i]);
            combination2(i+1, arr, target - arr[i], res, list,k);
            list.remove(list.size() - 1);
        }
    }
}
