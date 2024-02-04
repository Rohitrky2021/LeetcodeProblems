class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        
        int[] isChampion = new int[n];
        int champ = 0;
        
        for (int i = 0; i < n; i++) {
            boolean strongerThanOthers = false;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    strongerThanOthers = true;
                    isChampion[i]++;
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < isChampion[i]) {
                champ = i;
                max = isChampion[i];
            }
        }
        
        return champ;
    }
}
