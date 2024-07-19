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
import java.util.*;

class Solution {
    // Create graph from Tree 
    public void Treetograph(Map<TreeNode, List<TreeNode>> graph, TreeNode node) {
        if (node == null) return;

        if (!graph.containsKey(node)) {
            graph.put(node, new ArrayList<>());
        }

        if (node.left != null) {
            graph.get(node).add(node.left); // adding 1st time 
            graph.putIfAbsent(node.left, new ArrayList<>());
            graph.get(node.left).add(node); // Bidirectional hai tho adding again second time 
            Treetograph(graph, node.left);
        }

        if (node.right != null) {
            graph.get(node).add(node.right);
            graph.putIfAbsent(node.right, new ArrayList<>());
            graph.get(node.right).add(node);
            Treetograph(graph, node.right);
        }
    }

    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        Treetograph(graph, root);

        List<TreeNode> leafNodes = new ArrayList<>();
        findLeafNodes(root, leafNodes);

        int count = 0;

        for (int i = 0; i < leafNodes.size(); i++) {
            TreeNode leaf = leafNodes.get(i);
            count += bfsCountPairs(graph, leaf, leafNodes, distance);
        }

        // Since each pair is counted twice, divide by 2
        return count / 2;
    }

    private void findLeafNodes(TreeNode node, List<TreeNode> leafNodes) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            leafNodes.add(node);
            return;
        }
        findLeafNodes(node.left, leafNodes);
        findLeafNodes(node.right, leafNodes);
    }

    private int bfsCountPairs(Map<TreeNode, List<TreeNode>> graph, TreeNode start, List<TreeNode> leafNodes, int distance) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        Map<TreeNode, Integer> distMap = new HashMap<>();
        distMap.put(start, 0);

        int count = 0;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int currentDist = distMap.get(current);

            if (currentDist > distance) break;

            for (TreeNode neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    distMap.put(neighbor, currentDist + 1);
                    queue.add(neighbor);

                    if (currentDist + 1 <= distance && leafNodes.contains(neighbor) && neighbor != start) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        Solution solution = new Solution();
        int result = solution.countPairs(root, 3);
        System.out.println("Number of pairs: " + result);
    }
}
