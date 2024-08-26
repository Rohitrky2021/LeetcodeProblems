 

class Solution {
    // Class-level list to store postorder traversal
    List<Integer> ans = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        // Base case: if the root is null, return the result list
        if (root == null) {
            return ans;
        }
        
        // Iterate through all the children of the current node
        for (int i = 0; i < root.children.size(); i++) {
            // Recursively call postorder on each child
            postorder(root.children.get(i));
        }
        
        // After processing all children, add the value of the current node to the result list
        ans.add(root.val);
    
        // Return the complete postorder traversal result list
        return ans;
    }
}
