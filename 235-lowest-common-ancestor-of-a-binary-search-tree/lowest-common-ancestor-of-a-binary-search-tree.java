import java.util.*;

class Solution1 {
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
        if (root == null)
            return false;

        l.add(root);
        if (root == p)
            return true;

        if ((root.left != null && lca(root.left, p, l)) ||
                (root.right != null && lca(root.right, p, l))) {
            return true;
        }

        l.remove(l.size() - 1);

        return false;
    }
}

// Use the Greedy way as the Binary values on right are greater than the ones on the left
class Solution2 {

    public TreeNode lowestCommonAncestor(  TreeNode root,  TreeNode p,  TreeNode q) {
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(  root.right,    p,  q);
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(    root.left,   p,  q);
        return root;
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
