class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        traverse(root, null, 0, x, y);
        return d1 == d2 && par1 != par2;
    }

    int d1 = -1; // Depth of node x
    int d2 = -1; // Depth of node y
    TreeNode par1 = null; // Parent of node x
    TreeNode par2 = null; // Parent of node y

    private void traverse(TreeNode node, TreeNode parent, int depth, int x, int y) {
        if (node == null)
            return;

        if (node.val == x) {
            d1 = depth;
            par1 = parent;
        } else if (node.val == y) {
            d2 = depth;
            par2 = parent;
        }

        traverse(node.left, node, depth + 1, x, y);
        traverse(node.right, node, depth + 1, x, y);
    }
}
