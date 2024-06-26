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

    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        inorderHelper(node.left, result);
        result.add(node.val);
        inorderHelper(node.right, result);
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return creatBalancedBST( result.stream().mapToInt(i -> i).toArray(), 0,result.size()-1, root);
    }

     TreeNode creatBalancedBST(int values[], int s, int e, TreeNode root) {
        if (s > e) {
            return null;
        }
        int mid = (s + e) / 2;

        root = new TreeNode(values[mid]);
        root.left = creatBalancedBST(values, s, mid - 1, root.left);
        root.right = creatBalancedBST(values, mid + 1, e, root.right);

        return root;
    }
}