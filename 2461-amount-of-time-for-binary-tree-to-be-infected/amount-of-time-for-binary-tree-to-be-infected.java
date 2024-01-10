class Solution1 {
    public int amountOfTime(TreeNode root, int start) {
        Result result = h(root, start);
        return result.hasOtherNodes ? result.height : result.height - 1;
    }

    private Result h(TreeNode root, int start) {
        if (root == null) {
            return new Result(0, false);
        }

        Result leftResult = h(root.left, start);
        Result rightResult = h(root.right, start);

        int maxHeight = Math.max(leftResult.height, rightResult.height) + 1;

        boolean hasOtherNodes = (leftResult.hasOtherNodes || rightResult.hasOtherNodes);

        if (root.val == start) {
            hasOtherNodes = hasOtherNodes || (leftResult.height != 0 && rightResult.height != 0);
        }

        return new Result(maxHeight, hasOtherNodes);
    }

    private static class Result {
        int height;
        boolean hasOtherNodes;

        Result(int height, boolean hasOtherNodes) {
            this.height = height;
            this.hasOtherNodes = hasOtherNodes;
        }
    }
}

 

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

// Approach 1: Convert to Graph and Breadth-First Search

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
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, Set<Integer>> map = new HashMap<>();  
        convert(root, 0, map);
        Queue<Integer> queue = new LinkedList<>(); 
        queue.add(start);
        int minute = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
          
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize > 0) {
                int current = queue.poll();
                for (int num : map.get(current)) {
                    if (!visited.contains(num)) {
                        visited.add(num);
                        queue.add(num);
                    }
                }
                levelSize--;
            }
            minute++;
        }
        return minute - 1;
    }
 
    public void convert(TreeNode current, int parent, Map<Integer, Set<Integer>> map){
        if (current == null) {
            return;
        } 
        if (!map.containsKey(current.val)) {
            map.put(current.val, new HashSet<>());
        } 
        Set<Integer> adjacentList = map.get(current.val);
        if (parent != 0) {
            adjacentList.add(parent);
        } 
        if (current.left != null) {
            adjacentList.add(current.left.val);
        } 
        if (current.right != null) {
            adjacentList.add(current.right.val);
        } 
        convert(current.left, current.val, map);
        convert(current.right, current.val, map);
    }      
}