class Solution {
    public List<Integer> getRow(int r) {
        List<Integer> anss = new ArrayList<>();
        if(r ==0){
             anss.add(1);
             return anss;
        } 
        int ans[][] = new int[r+1][r+1];
        if(ans.length>=1)
        ans[0][0] = 1;

        for (int i = 1; i < ans.length; i++) {
             ans[i][0] = 1;
            for (int j = 1; j < i ; j++) {
                ans[i][j] = ans[i - 1][j] + ans[i - 1][j - 1];
            }
            ans[i][i] = 1;
        }

        for(int i:ans[r]){
            anss.add(i);
        }
        return anss;
        
    }
}