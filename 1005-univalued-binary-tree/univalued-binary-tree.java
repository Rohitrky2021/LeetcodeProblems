class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTreeHelper(root, root.val);
    }

    private boolean isUnivalTreeHelper(TreeNode node, int value) {
        if (node == null) {
            return true;
        }

        if (node.val != value) {
            return false;
        }

        boolean left = isUnivalTreeHelper(node.left, value);
        boolean right = isUnivalTreeHelper(node.right, value);

        return left && right;
    }
}
