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
    public boolean evaluateTree(TreeNode root) {
        return traverseBottomUp(root);
    }
    boolean ans;

    public boolean traverseBottomUp(TreeNode root) {
        if (root == null) return false;
        if(root.val==0)return false;
        if(root.val==1) return true;

        // Traverse left subtree
        boolean l= traverseBottomUp(root.left);

        // Traverse right subtree
       boolean r= traverseBottomUp(root.right);

        if(root.val==2){
            ans=l|r;
        }else if(root.val==3){
            ans=l&r;
        }

        return ans;
    }
}