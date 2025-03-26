class Solution {

    class Info {
        int h;
        int diam;

        Info(int h, int diam) {
            this.h = h;
            this.diam = diam;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root).diam;
    }

    private Info helper(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = helper(root.left);
        Info rightInfo = helper(root.right);

        int mlh = leftInfo.h;
        int mrh = rightInfo.h;

        int height = Math.max(mlh, mrh) + 1;
        int diameter = Math.max(leftInfo.diam, Math.max(rightInfo.diam, mlh + mrh));

        return new Info(height, diameter);
    }
}
