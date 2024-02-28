/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;
    int maxDepth = -1;

    public int findBottomLeftValue(TreeNode root) {
        traverse(root, 0);
        return ans;
    }

    private void traverse(TreeNode node, int depth) {
        if (node == null)
            return;

        if (depth > maxDepth) {
            ans = node.val;
            maxDepth = depth;
        }

        traverse(node.left, depth + 1);
        traverse(node.right, depth + 1);
    }
}
