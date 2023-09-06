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

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
                return 0;
            }
            int leftdiam = diameterOfBinaryTree(root.left);
            int lh = height(root.left);
            int rigthdiam = diameterOfBinaryTree(root.right);
            int rh = height(root.right);

            int selfdiam = lh + rh;

            return Math.max(leftdiam, Math.max(rigthdiam, selfdiam));

    }

    public  int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        int maxh = Math.max(lh, rh) + 1;
        // System.out.println(maxh);
        return maxh;
    }
}
