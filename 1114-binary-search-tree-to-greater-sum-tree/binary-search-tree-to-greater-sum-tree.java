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
    public TreeNode bstToGst(TreeNode root) {
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

class Solution {
    public TreeNode bstToGst(TreeNode root) {
        int[] ans = new int[101];

        travel(root, ans);

        for (int i = ans.length - 2; i >= 0; i--) {
            ans[i] += ans[i + 1];
        }

        TreeNode finalTree = construct(root, ans);

        return finalTree;
    }

    public TreeNode construct(TreeNode root, int[] ans) {
        if (root == null) return null;

        construct(root.left, ans);
        root.val = ans[root.val];
        construct(root.right, ans);

        return root;
    }

    public void travel(TreeNode root, int[] ans) {
        if (root == null) return;

        travel(root.left, ans);
        ans[root.val]=root.val;
        travel(root.right, ans);
    }
}
