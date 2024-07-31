import java.util.HashMap;

class Solution1 {
    public int minHeightShelves(int[][] books, int sw) {
        int ans = Integer.MAX_VALUE;
        HashMap<String, Integer> hm = new HashMap<>();
        return topdown(hm, books, sw, 0, ans);
    }

    public int topdown(HashMap<String, Integer> hm, int[][] books, int sw, int idx, int ans) {
        String key = sw + "," + idx;
        if (hm.containsKey(key)) return hm.get(key);

        if (idx == books.length) return 0;

        int height = 0, width = 0, minHeight = Integer.MAX_VALUE;
        for (int i = idx; i < books.length && width + books[i][0] <= sw; i++) {
            height = Math.max(height, books[i][1]);
            width += books[i][0];
            minHeight = Math.min(minHeight, height + topdown(hm, books, sw, i + 1, ans));
        }

        hm.put(key, minHeight);
        return minHeight;
    }
}


class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[][] dp = new int[shelfWidth+1][books.length];

        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return minHeightShelvesHelper(books, 0, shelfWidth, 0, shelfWidth, dp);
        
    }

    public int minHeightShelvesHelper(int[][] books, int i, int currShelfWidth, int currMaxHeightRow, int shelfWidth, int[][] dp){
        
        if(i>=books.length){
            return currMaxHeightRow;
        }

        if(dp[currShelfWidth][i] != -1){
            return dp[currShelfWidth][i];
        }
        
        int x = Integer.MAX_VALUE;
        if(books[i][0] <= currShelfWidth){
            x = minHeightShelvesHelper(books, i+1, currShelfWidth-books[i][0], Math.max(currMaxHeightRow, books[i][1]), shelfWidth, dp);
        }
        int y = Integer.MAX_VALUE;
        if(currShelfWidth != shelfWidth){
            y = currMaxHeightRow + minHeightShelvesHelper(books, i, shelfWidth, 0, shelfWidth, dp);
        }
        dp[currShelfWidth][i] = Math.min(x,y);
        return dp[currShelfWidth][i];
    }
}