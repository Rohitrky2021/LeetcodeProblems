/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { this.val = val; }
 * }
 */

class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        // Find the Lowest Common Ancestor (LCA) of startValue and destValue
        TreeNode lca = findLCA(root, startValue, destValue);

        // Get path from LCA to startValue and convert it to "U" (Up)
        String pathToStart = findPath(lca, startValue);
        String pathFromStartToLCA = "U".repeat(pathToStart.length());

        // Get path from LCA to destValue
        String pathToDest = findPath(lca, destValue);

        // Concatenate paths to get the final directions
        return pathFromStartToLCA + pathToDest;
    }

    /**
     * Finds the Lowest Common Ancestor (LCA) of two nodes.
     */
    private TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }

        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if (left != null && right != null) return root; // LCA found
        return (left != null) ? left : right; // Return the non-null subtree
    }

    /**
     * Finds the path from the given root node to the target value.
     * Uses 'L' for left traversal and 'R' for right traversal.
     */
    private String findPath(TreeNode root, int target) {
        StringBuilder path = new StringBuilder();
        return dfs(root, target, path) ? path.toString() : "";
    }

    /**
     * DFS Helper function to build the path.
     */
    private boolean dfs(TreeNode node, int target, StringBuilder path) {
        if (node == null) return false;
        if (node.val == target) return true;

        path.append('L');
        if (dfs(node.left, target, path)) return true;
        path.setLength(path.length() - 1); // Backtrack

        path.append('R');
        if (dfs(node.right, target, path)) return true;
        path.setLength(path.length() - 1); // Backtrack

        return false;
    }
}
