class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLCA(root, startValue, destValue);

        // Path from LCA to startValue node
        String pathToStart = getPath(lca, startValue, new StringBuilder());
        // Transform the path from LCA to startValue to "U" (Up)
        String pathFromStartToLCA = "U".repeat(pathToStart.length());

        // Path from LCA to destValue node
        String pathToDest = getPath(lca, destValue, new StringBuilder());

        return pathFromStartToLCA + pathToDest;
    }

    // Helper method to find the LCA of two nodes
    private TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) return root;

        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    // Helper method to get the path from a node to a target value
    private String getPath(TreeNode root, int value, StringBuilder path) {
        if (root == null) return "";
        if (root.val == value) return path.toString();

        path.append('L');
        String leftPath = getPath(root.left, value, path);
        if (!leftPath.isEmpty()) return leftPath;
        path.setLength(path.length() - 1);

        path.append('R');
        String rightPath = getPath(root.right, value, path);
        if (!rightPath.isEmpty()) return rightPath;
        path.setLength(path.length() - 1);

        return "";
    }
}
