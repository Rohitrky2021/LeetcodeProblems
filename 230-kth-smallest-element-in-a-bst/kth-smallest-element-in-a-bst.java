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
    private int count = 0;
    private int result = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        inorderTraversal(root, k);
        return result;
    }
    
    private void inorderTraversal(TreeNode node, int k) {
        if(node == null) return;
        
        inorderTraversal(node.left, k);
        
        count++;
        if(count == k) {
            result = node.val;
            return;
        }
        
        inorderTraversal(node.right, k);
    }
}
