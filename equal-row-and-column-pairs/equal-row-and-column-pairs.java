import java.util.HashMap;

class Solution {
    public int equalPairs(int[][] grid) {
        int pair = 0;
        
        for (int i = 0; i < grid.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            
            for (int j = 0; j < grid[i].length; j++) {
                map.put(j, grid[j][i]);
            }
            
            int curr = 1;
            for (int k = 0; k < grid.length; k++) {
                for (int m = 0; m < grid.length; m++) {
                    if (map.get(m) != grid[k][m]) {
                        curr = 0;
                        break;
                    }
                }
                pair += curr;
                curr=1;
            }
        }
        
        return pair;
    }
}
