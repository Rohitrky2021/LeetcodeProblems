class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int currs = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            currs = root.left.val;
        }

        return currs + helper(root.left) + helper(root.right);
    }
}
