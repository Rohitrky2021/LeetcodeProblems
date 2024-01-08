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
class Solution0 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root==null ) return 0;

        if(root.val>=low && root.val<=high){
           int lsum= rangeSumBST(root.left, low,  high);
            int Rsum= rangeSumBST(root.right, low,  high);

            return lsum+Rsum+root.val;
            

        }else{          
            int lsum= rangeSumBST(root.left, low,  high);
            int Rsum= rangeSumBST(root.right, low,  high);

            return lsum+Rsum+0;
        }
    }
}

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int sum = 0;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        int lsum = rangeSumBST(root.left, low, high);
        int rsum = rangeSumBST(root.right, low, high);

        return sum + lsum + rsum;
    }
}
