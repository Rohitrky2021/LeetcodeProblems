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
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int currentLength = queue.size();
            int currMax = Integer.MIN_VALUE;
            
            for (int i = 0; i < currentLength; i++) {
                TreeNode node = queue.remove();
                currMax = Math.max(currMax, node.val);
                
                if (node.left != null) {
                    queue.add(node.left);
                }
                
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            
            ans.add(currMax);
        }
        
        return ans;
    }
}
class Solution2 {

    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        q.offer(root);
     
        while (!q.isEmpty()) {
            int max=Integer.MIN_VALUE;
            int levelSize = q.size();
 
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();
  
                max=Math.max(max,curr.val);
                if (curr.left != null) {

                    q.offer(curr.left); // Adding the left part of Node
                }
                if (curr.right != null) { // Adding the Right part of Node
                    q.offer(curr.right);
                }
            }
 
            ans.add(max);
 
        }
        return ans;
    }
}

class Solution3 {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        q.offer(root);
     
        while (!q.isEmpty()) {
            int levelSize = q.size();
            int max = Integer.MIN_VALUE; // Initialize max for the current level
 
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();
                max = Math.max(max, curr.val);
                if (curr.left != null) {
                    q.offer(curr.left); // Adding the left part of Node
                }
                if (curr.right != null) {
                    q.offer(curr.right); // Adding the Right part of Node
                }
            }
 
            ans.add(max); // Add the maximum value for the current level to the result list
        }
        return ans;
    }
}

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

//             Collections.reverse(currentlevel);
//             ans.add(currentlevel.stream().max(Comparator.comparingInt(Integer::intValue)));

//             //  ans.add(currentlevel);
//             level++;
//         }
//         return ans;
//     }
// }
