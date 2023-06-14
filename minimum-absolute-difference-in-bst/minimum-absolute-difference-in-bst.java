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
// class Solution {
//     public int getMinimumDifference(TreeNode root) {
        
//     }
// }
class Solution {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorderTraversal(root, values);
        Collections.sort(values);
        
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < values.size(); i++) {
            int diff = values.get(i) - values.get(i-1);
            minDiff = Math.min(minDiff, diff);
        }
        
        return minDiff;
    }
    
    private void inorderTraversal(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }
        
        inorderTraversal(root.left, values);
        values.add(root.val);
        inorderTraversal(root.right, values);
    }
}
