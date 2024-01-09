class Solution1 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList();
        List<Integer> leaves2 = new ArrayList();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    public void dfs(TreeNode node, List<Integer> leafValues) {
        if (node != null) {
            if (node.left == null && node.right == null)
                leafValues.add(node.val);
            dfs(node.left, leafValues);
            dfs(node.right, leafValues);
        }
    }
}

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
class Solution2 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList();
        List<Integer> leaves2 = new ArrayList();
         collectLeaves(root1, leaves1);
        collectLeaves(root2, leaves2);
        return leaves1.equals(leaves2);
    }

   private void collectLeaves(TreeNode node, List<Integer> leafValues) {
        if (node == null) {
            return;
        }
        
        if (node.left == null && node.right == null) {
            leafValues.add(node.val);
        } else {
            collectLeaves(node.left, leafValues);
            collectLeaves(node.right, leafValues);
        }
    }
}


class Solution {

    ArrayList<Integer> r1 = new ArrayList<>();
    ArrayList<Integer> r2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        leaf(root1);
        leaf2(root2);

        System.out.print("r1: ");
        for (int value : r1) {
            System.out.print(value + " ");
        }
        System.out.println();

        System.out.print("r2: ");
        for (int value : r2) {
            System.out.print(value + " ");
        }

        return r1.equals(r2);
    }
 

    public void leaf2(TreeNode ro1) {
        if (ro1 != null) {
            if (ro1.left == null && ro1.right == null) r2.add(ro1.val);
            leaf2(ro1.left);
            leaf2(ro1.right);
        }
    }

    public void leaf(TreeNode ro1) {
        if (ro1 != null) {
            if (ro1.left == null && ro1.right == null) r1.add(ro1.val);
            leaf(ro1.left);
            leaf(ro1.right);
        }
    }
 
}