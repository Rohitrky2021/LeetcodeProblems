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

//  Same But From Bottom to up

class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();

            List<Integer> currentlevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();
                currentlevel.add(curr.val);

                if (curr.left != null) {
                    q.offer(curr.left); // Adding the left part of Node
                }
                if (curr.right != null) { // Adding the Right part of Node
                    q.offer(curr.right);
                }
            }

            ans.add(currentlevel);
        }
        for (int i = ans.size() - 1; i >= 0; i--) {
            ans.add(ans.get(i));
            ans.remove(i);
        }

        return ans;
    }
}
