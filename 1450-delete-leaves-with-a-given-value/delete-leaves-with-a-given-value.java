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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return traverse(root, null, target);
    }

    private TreeNode traverse(TreeNode node, TreeNode parent, int target) {
        if (node == null)
            return null;

        node.left = traverse(node.left, node, target);
        node.right = traverse(node.right, node, target);

        if (node.left == null && node.right == null && node.val == target) {
            if (parent != null) {
                if (parent.left == node)
                    parent.left = null;
                else if (parent.right == node)
                    parent.right = null;
            }
            return null; // Remove the current node
        }

        return node;
    }
}


// class Solution {
//     public boolean isCousins(TreeNode root, int x, int y) {
//         traverse(root, null, 0, x, y);
//         return d1 == d2 && par1 != par2;
//     }

//     int d1 = -1; // Depth of node x
//     int d2 = -1; // Depth of node y
//     TreeNode par1 = null; // Parent of node x
//     TreeNode par2 = null; // Parent of node y

//     private void traverse(TreeNode node, TreeNode parent, int depth, int x, int y) {
//         if (node == null)
//             return;

//         if (node.val == x) {
//             d1 = depth;
//             par1 = parent;
//         } else if (node.val == y) {
//             d2 = depth;
//             par2 = parent;
//         }

//         traverse(node.left, node, depth + 1, x, y);
//         traverse(node.right, node, depth + 1, x, y);
//     }
// }
