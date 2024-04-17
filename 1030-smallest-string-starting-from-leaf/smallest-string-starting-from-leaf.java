import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    List<String> s = new ArrayList<>();

    public String smallestFromLeaf(TreeNode root) {
        depth(root, new StringBuilder());
        Collections.sort(s);
        return s.get(0);
    }

    public void depth(TreeNode root, StringBuilder ans) {
        if (root == null) return;

        ans.append((char) ('a' + root.val));

        if (root.left == null && root.right == null) {
            // s.add(ans.reverse().toString());
            // ans.reverse();

        s.add(new StringBuilder(ans).reverse().toString());

        }

        depth(root.left, ans);
        depth(root.right, ans);

        ans.deleteCharAt(ans.length() - 1);
    }
}
