import java.util.*;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        List<TreeNode> l1 = new ArrayList<>();
        List<TreeNode> l2 = new ArrayList<>();
        lca(root, p, l1);
        lca(root, q, l2);

        int i = 0;
        while (i < l1.size() && i < l2.size() && l1.get(i) == l2.get(i)) {
            i++;
        }

        return l1.get(i - 1);
    }

    public boolean lca(TreeNode root, TreeNode p, List<TreeNode> l) {
        if (root == null) return false;

        l.add(root);
        if (root == p) return true;

        if ((root.left != null && lca(root.left, p, l)) || 
            (root.right != null && lca(root.right, p, l))) {
            return true;
        }

        l.remove(l.size() - 1);

        return false;
    }
}

