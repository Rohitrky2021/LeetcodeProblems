class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return buildPart(preorder, inorder, 0, n - 1, 0);
    }

    public TreeNode buildPart(int[] preorder, int[] inorder, int start, int end, int idx) {
        if (start > end) return null;
        
        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);

        // Find the index of the root value in the inorder traversal
        int inorderIdx = start;
        while (inorder[inorderIdx] != rootVal) {
            inorderIdx++;
        }

        // Recursive calls to build left and right subtrees
        root.left = buildPart(preorder, inorder, start, inorderIdx - 1, idx + 1);
        // For the right subtree, the starting index for preorder is calculated as:
        // idx + (number of nodes in the left subtree) + 1
        root.right = buildPart(preorder, inorder, inorderIdx + 1, end, idx + (inorderIdx - start) + 1);
        
        return root;
    }
}
