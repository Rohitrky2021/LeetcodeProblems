class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        return hasPathSumHelper(root, targetSum);
    }

    private boolean hasPathSumHelper(TreeNode node, int sum) {
        if (node == null) {
            return false;
        }

        if (node.left == null && node.right == null) {
            return sum == node.val;
        }

        int remainingSum = sum - node.val;
        return hasPathSumHelper(node.left, remainingSum) || hasPathSumHelper(node.right, remainingSum);
    }
}
