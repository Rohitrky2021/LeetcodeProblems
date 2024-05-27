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
class Solution1 {
    public boolean isValidBST(TreeNode root) {
        if(root==null)return false;
        if(root.left == null && root.right == null )return true;

       if( root.left != null && root.right != null && root.left.val<root.right.val && root.val<root.right.val)return true;
       boolean l= isValidBST(root.left) ;
       boolean r= isValidBST(root.right); 


        return l && r;
        
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    private boolean isValidBST(TreeNode node, TreeNode min, TreeNode max) {
        if (node == null) return true;

        // Check if the current node's value is within the valid range
        if ((min != null && node.val <= min.val) || (max != null && node.val >= max.val)) {
            return false;
        }

        // Recursively validate left and right subtrees with updated range
        return isValidBST(node.left, min, node) && isValidBST(node.right, node, max);
    }
}
