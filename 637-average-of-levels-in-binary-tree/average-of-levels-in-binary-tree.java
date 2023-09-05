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

    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> ans = new ArrayList<>();
        
        if (root == null) {
            return ans;
        }

        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();

            List<Integer> currentlevel = new ArrayList<>();
            Double toadd=0.0;

            Double adder=0.;
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();
                adder+=curr.val;
                if (curr.left != null) {
                    q.offer(curr.left); // Adding the left part of Node
                }
                if (curr.right != null) { // Adding the Right part of Node
                    q.offer(curr.right);
                }

            }
                toadd=adder/levelSize;
                //  currentlevel.add(toadd);

            ans.add(toadd);
        }
        return ans;
    }
}
