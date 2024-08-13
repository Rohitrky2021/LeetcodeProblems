class Solution1 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        combination2( 0,candidates, target, res, list);
        return res;
    }
    public void combination2(int index, int[] arr, int target, List<List<Integer>> res, List<Integer> list){
        if(target == 0){
            Collections.sort(list);
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i < arr.length;i++){
            if(i > index && arr[i] == arr[i - 1]) continue;
            if(target < arr[i]) break;

            list.add(arr[i]);
            combination2(i + 1, arr, target - arr[i], res, list);
            list.remove(list.size() - 1);
        }
    }
}


class Solution {
    static List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        
        int[] fq = new int[31];
        for(int i : candidates) if(i < 31) fq[i]++;
        
        fun(0 , fq , target , new ArrayList<>());
        
        return ans;
    }
    
    void fun(int i , int[] fq , int target , List<Integer> list){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        if(target < 0 || target < i) return;
        
        if(fq[i] > 0){
            fq[i]--;
            list.add(i);
            fun(i , fq , target - i , list);
            fq[i]++;
            list.remove(list.size() - 1);
        }
        
        fun(i+1 , fq , target , list);
    }
}