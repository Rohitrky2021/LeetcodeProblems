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
    
    
    Map<TreeNode, Integer> memo = new HashMap<>();

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        int selfDiameter = height(root.left) + height(root.right);

        return Math.max(leftDiameter, Math.max(rightDiameter, selfDiameter));
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (memo.containsKey(node)) {
            return memo.get(node);
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int maxHeight = Math.max(leftHeight, rightHeight) + 1;
        memo.put(node, maxHeight);

        return maxHeight;
    }
}