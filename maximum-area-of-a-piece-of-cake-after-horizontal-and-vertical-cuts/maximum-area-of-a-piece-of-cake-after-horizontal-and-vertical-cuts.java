class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long maxHightOfPiece = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        long maxWidthOfPiece = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);

        for(int i = 1; i < horizontalCuts.length; i++) {
            maxHightOfPiece = Math.max(maxHightOfPiece, horizontalCuts[i] - horizontalCuts[i-1]);
        }

        for(int i = 1; i < verticalCuts.length; i++) {
            maxWidthOfPiece = Math.max(maxWidthOfPiece, verticalCuts[i] - verticalCuts[i-1]);
        }

        return (int)((maxHightOfPiece * maxWidthOfPiece) % (long)(Math.pow(10, 9) + 7));
    }
}