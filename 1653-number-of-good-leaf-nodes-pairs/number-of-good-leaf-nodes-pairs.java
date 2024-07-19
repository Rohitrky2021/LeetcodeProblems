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

class Solution1 {
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

class Solution2 {
    // Create graph from Tree 
    public void Treetograph(Map<TreeNode, List<TreeNode>> graph, TreeNode node) {
        if (node == null) return;

        if (!graph.containsKey(node)) {
            graph.put(node, new ArrayList<>());
        }

        if (node.left != null) {
            graph.get(node).add(node.left);
            graph.putIfAbsent(node.left, new ArrayList<>());
            graph.get(node.left).add(node);
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
        return count;
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

                    if (currentDist + 1 <= distance && leafNodes.contains(neighbor) &&
                        leafNodes.indexOf(current) < leafNodes.indexOf(neighbor)) {      // Only adjusted these callls 
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


class Solution3 {
  public int countPairs(TreeNode root, int distance) {
        int[] result= new int[1];
        dfs(root,distance,result);
        return result[0];
    }
    private int[] dfs(TreeNode node,int distance, int[] result){
        if(node==null){
            return new int[distance+1];
        }
        if(node.left==null&&node.right==null){
            int[] leafDistance = new int[distance+1];
            leafDistance[1]=1;
            return leafDistance;
        }

        int[] left=dfs(node.left,distance,result);
        int[] right= dfs(node.right,distance,result);

        //calculate result
        for(int i=1;i<=distance;i++){
            for(int j=1;j<=distance-i;j++){
                result[0] += left[i]*right[j];
            }
        }

        int[] leafDistance = new int[distance+1];
        for(int i=1;i<distance;i++){
            leafDistance[i+1]= left[i]+ right[i];
        }
        return leafDistance;
    }
}


class Solution4 {
    public int countPairs(TreeNode root, int distance) {
        if (root == null) {
            return 0;
        }
        int ans = countPairs(root.left, distance) + countPairs(root.right, distance);
        int[] cnt1 = new int[distance];
        int[] cnt2 = new int[distance];
        dfs(root.left, cnt1, 1);
        dfs(root.right, cnt2, 1);
        for (int i = 0; i < distance; ++i) {
            for (int j = 0; j < distance; ++j) {
                if (i + j <= distance) {
                    ans += cnt1[i] * cnt2[j];
                }
            }
        }
        return ans;
    }

    void dfs(TreeNode root, int[] cnt, int i) {
        if (root == null || i >= cnt.length) {
            return;
        }
        if (root.left == null && root.right == null) {
            ++cnt[i];
            return;
        }
        dfs(root.left, cnt, i + 1);
        dfs(root.right, cnt, i + 1);
    }
}

// Now using LCA 
 

class Solution {
    // Definition for a binary tree node.
     
    boolean goodLeaf(String str1, String str2, int distance) {
        int n = Math.min(str1.length(), str2.length());
        int i = 0;
        for (; i < n; i++) {
            if (str1.charAt(i) != str2.charAt(i)) break;
        }
        int len1 = str1.length() - i;
        int len2 = str2.length() - i;
        return (len1 + len2) <= distance;
    }

    void f(TreeNode root, List<String> path, StringBuilder temp) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            temp.append('L');
            f(root.left, path, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
        if (root.right != null) {
            temp.append('R');
            f(root.right, path, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
        if (root.left == null && root.right == null) {
            path.add(temp.toString());
        }
        return;
    }

    public int countPairs(TreeNode root, int distance) {
        List<String> path = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        f(root, path, temp);
        int ret = 0;
        for (int i = 0; i < path.size(); i++) {
            for (int j = i + 1; j < path.size(); j++) {
                if (goodLeaf(path.get(i), path.get(j), distance)) {
                    ret++;
                }
            }
        }
        return ret;
    }

     
}




