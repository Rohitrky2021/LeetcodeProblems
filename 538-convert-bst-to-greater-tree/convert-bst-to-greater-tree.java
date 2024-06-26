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
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        int[] sum = new int[1]; // to hold the cumulative sum
        convertBST(root, sum);
        return root;
    }

    private void convertBST(TreeNode node, int[] sum) {
        if (node == null) return;
        // Reverse in-order traversal (right-root-left)
        convertBST(node.right, sum);
        // Update the node value with the cumulative sum
        sum[0] += node.val;
        node.val = sum[0];
        convertBST(node.left, sum);
    }
}