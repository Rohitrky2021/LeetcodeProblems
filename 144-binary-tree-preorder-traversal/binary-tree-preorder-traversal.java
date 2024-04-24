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
    public List<Integer> preorderTraversal(TreeNode root) {
                List<Integer> nodes = new ArrayList<>();
        inorderTraversal(root, nodes);

        return nodes;
    }

    private void inorderTraversal(TreeNode node, List<Integer> nodes) {
        if (node == null) {
            return;
        }

        nodes.add(node.val);
        inorderTraversal(node.left, nodes);
        inorderTraversal(node.right, nodes);
    }
}

 