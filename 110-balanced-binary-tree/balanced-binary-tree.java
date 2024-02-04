class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int h1 = heightOfTree(root.left);
        int h2 = heightOfTree(root.right);

        // Check if the left and right subtrees are balanced
        if (Math.abs(h1 - h2) > 1) return false;

        // Recursively check the balance of left and right subtrees
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int heightOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }
}
