import java.util.HashMap;

class Solution {
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
