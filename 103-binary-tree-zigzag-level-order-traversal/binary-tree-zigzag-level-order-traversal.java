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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        q.offer(root);

        int level = 1;
        boolean flag = false;
        while (!q.isEmpty()) {
            int levelSize = q.size();

            List<Integer> currentlevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();
                if (!flag) {
                    currentlevel.add(0, curr.val); // Add to the beginning for reverse order
                } else {
                    currentlevel.add(curr.val); // Add to the end for normal order
                }

                if (curr.right != null) { // Adding the Right part of Node
                    q.offer(curr.right);
                }
                if (curr.left != null) {
                    q.offer(curr.left); // Adding the left part of Node
                }
            }
            ans.add(currentlevel);
            flag = !flag;
        }
        return ans;
    }
}
// class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         List<List<Integer>> ans = new ArrayList<>();
//         LinkedList<TreeNode> currLevel = new LinkedList<>();
//         if (root == null) return ans;
//         currLevel.add(root);
//         boolean ltr = false;
//         while (currLevel != null && currLevel.size() != 0) {
//             LinkedList<Integer> currLevelVal = new LinkedList<>();
//             int n = currLevel.size();
//             int i = n - 1;
//             LinkedList<TreeNode> nextLevel = new LinkedList<>();
//             while (i >= 0) {
//                 root = currLevel.pollLast();
//                 currLevelVal.addFirst(root.val);
//                 if (ltr) {
//                     if (root.left != null) nextLevel.add(root.left);
//                     if (root.right != null) nextLevel.add(root.right);
//                 } else {
//                     if (root.right != null) nextLevel.add(root.right);
//                     if (root.left != null) nextLevel.add(root.left);
//                 }
//                 i--;
//             }
//             ans.add(currLevelVal);
//             ltr = !ltr;
//             currLevel = nextLevel;
//         }
//         return ans;
//     }
// }
// Here After getting Added We Are Reverseing So a Bad Approach in TC and SC ==> But Not that much Bad
// class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         Queue<TreeNode> q = new LinkedList<>();
//         ArrayList<List<Integer>> ans = new ArrayList<>();
//         if (root == null) {
//             return ans;
//         }
//         q.offer(root);
//         int level = 1;
//         while (!q.isEmpty()) {
//             int levelSize = q.size();
//             List<Integer> currentlevel = new ArrayList<>();
//             for (int i = 0; i < levelSize; i++) {
//                 TreeNode curr = q.poll();
//                 currentlevel.add(curr.val);
//                 if (curr.left != null) {
//                     q.offer(curr.left); // Adding the left part of Node
//                 }
//                 if (curr.right != null) { // Adding the Right part of Node
//                     q.offer(curr.right);
//                 }
//             }
//             if (level % 2 == 0) {
//                 Collections.reverse(currentlevel);
//                 ans.add(currentlevel);
//             }else{
//                 ans.add(currentlevel);
//             }
//             //  ans.add(currentlevel);
//             level++;
//         }
//         return ans;
//     }
// }
