class Solution1 {
    public int sumNumbers(TreeNode root) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        int sum = 0;
        helper(root, currentPath, paths);
        for (List<Integer> path : paths) {
            int pathSum = 0;
            for (int i = 0; i < path.size(); i++) {
                pathSum += path.get(i) * Math.pow(10, path.size() - i - 1);
            }
            sum += pathSum;
        }
        return sum;
    }

    public void helper(TreeNode root, List<Integer> currentPath, List<List<Integer>> paths) {
        if (root == null) {
            return;
        }
        currentPath.add(root.val);
        if (root.left == null && root.right == null) {
            paths.add(new ArrayList<>(currentPath));
        }
        helper(root.left, currentPath, paths);
        helper(root.right, currentPath, paths);
        currentPath.remove(currentPath.size() - 1);
    }
}



class Solution {
    // Initialize the variable to store the final sum
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0; // If the root is null, return 0
        }
        helper(root, new ArrayList<Integer>()); // Call the recursive helper function with the root and an empty list
        return sum; // Return the final sum
    }

    // Recursive helper function to traverse the tree and calculate the sum of all root-to-leaf paths
    private void helper(TreeNode node, List<Integer> path) {
        if (node == null) {
            return; // If the node is null, return
        }
        path.add(node.val); // Add the current node's value to the path list
        if (node.left == null && node.right == null) {
            int num = convertToInt(path); // If the node is a leaf node, convert the path list to an integer
            sum += num; // Add the integer to the final sum
        } else {
            helper(node.left, path); // Recursively traverse the left subtree with the current path
            helper(node.right, path); // Recursively traverse the right subtree with the current path
        }
        path.remove(path.size() - 1); // Remove the current node's value from the path list before returning to the parent
    }

    // Helper function to convert a list of integers into a single integer
    private int convertToInt(List<Integer> path) {
        int num = 0;
        for (int i = 0; i < path.size(); i++) {
            num = num * 10 + path.get(i); // Calculate the integer by concatenating the digits in the list
        }
        return num;
    }
}