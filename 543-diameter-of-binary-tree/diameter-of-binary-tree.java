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
    int diameter = 0;

    // // Array Method Used Unqie But not in SC but --> Can be used in DIfferent Variation of Questions // Ya Best in TC
    // public int diameterOfBinaryTree(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }

    //     int[] result = diameterHelper(root);
    //     return Math.max(result[0], result[1]) - 1;
    // }

    // public int[] diameterHelper(TreeNode node) {
    //     if (node == null) {
    //         return new int[] { 0, 0 };
    //     }

    //     int[] left = diameterHelper(node.left);
    //     int[] right = diameterHelper(node.right);

    //     int maxPathThroughRoot = left[0] + right[0] + 1;
    //     int maxDiameterWithoutRoot = Math.max(left[1], right[1]);

    //     int currentMaxDiameter = Math.max(maxPathThroughRoot, maxDiameterWithoutRoot);

    //     int currentMaxPath = Math.max(left[0], right[0]) + 1;

    //     return new int[] { currentMaxPath, currentMaxDiameter };
    // }

    // Kunal Best Method  +   Used DP in it

    Map<TreeNode, Integer> memo = new HashMap<>();

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter - 1;
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (memo.containsKey(node)) {
            return memo.get(node);
        }

        int lh = height(node.left);
        int rh = height(node.right);

        int dia = lh + rh + 1;
        diameter = Math.max(diameter, dia);

        int maxHeight = Math.max(lh, rh) + 1;
        memo.put(node, maxHeight);

        return maxHeight;
    }

    // public int diameterOfBinaryTree(TreeNode root) {
    //     Map<TreeNode, Integer> memo = new HashMap<>();
    //     return diameter(root, memo) - 1;
    // }

    // public int diameter(TreeNode node, Map<TreeNode, Integer> memo) {
    //     if (node == null) {
    //         return 0;
    //     }

    //     if (memo.containsKey(node)) {
    //         return memo.get(node);
    //     }

    //     int lh = diameter(node.left, memo);
    //     int rh = diameter(node.right, memo);

    //     int dia = lh + rh + 1;
    //     diameter = Math.max(diameter, dia);

    //     int height = Math.max(lh, rh) + 1;
    //     memo.put(node, height);

    //     return height;
    // }

    // Kunal Best Method

    // public int diameterOfBinaryTree(TreeNode root) {
    //     height(root);
    //     return diameter - 1;
    // }

    // public int height(TreeNode node) {
    //     if (node == null) {
    //         return 0;
    //     }
    //     int lh = height(node.left);
    //     int rh = height(node.right);

    //     int dia = lh + rh + 1;
    //     diameter = Math.max(diameter, dia);

    //     return Math.max(lh, rh) + 1;
    // }

    // // // Bad N^2 Method
    // // public int diameterOfBinaryTree(TreeNode root) {
    // //     if (root == null) {
    // //         return 0;
    // //     }
    // //     int leftdiam = diameterOfBinaryTree(root.left);
    // //     int lh = height(root.left);
    // //     int rigthdiam = diameterOfBinaryTree(root.right);
    // //     int rh = height(root.right);

    // //     int selfdiam = lh + rh;

    // //     return Math.max(leftdiam, Math.max(rigthdiam, selfdiam));
    // // }

    // // public int height(TreeNode root) {
    // //     if (root == null) {
    // //         return 0;
    // //     }
    // //     int lh = height(root.left);
    // //     int rh = height(root.right);

    // //     int maxh = Math.max(lh, rh) + 1;
    // //     // System.out.println(maxh);
    // //     return maxh;
    // // }

    // Map<TreeNode, Integer> memo = new HashMap<>();

    // public int diameterOfBinaryTree(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }

    //     int leftDiameter = diameterOfBinaryTree(root.left);
    //     int rightDiameter = diameterOfBinaryTree(root.right);

    //     int selfDiameter = height(root.left) + height(root.right);

    //     return Math.max(leftDiameter, Math.max(rightDiameter, selfDiameter));
    // }

    // public int height(TreeNode node) {
    //     if (node == null) {
    //         return 0;
    //     }

    //     if (memo.containsKey(node)) {
    //         return memo.get(node);
    //     }

    //     int leftHeight = height(node.left);
    //     int rightHeight = height(node.right);

    //     int maxHeight = Math.max(leftHeight, rightHeight) + 1;
    //     memo.put(node, maxHeight);

    //     return maxHeight;
    // }
}
