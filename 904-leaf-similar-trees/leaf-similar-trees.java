class Solution {

    ArrayList<TreeNode> r1 = new ArrayList<>();
    ArrayList<TreeNode> r2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        leaf(root1);
        leaf2(root2);

        System.out.print("r1: ");
        for (TreeNode node : r1) {
            System.out.print(node.val + " ");
        }
        System.out.println();

         for (TreeNode node : r2) {
            System.out.print(node.val + " ");
        }

        return valuesEqual(r1, r2);
    }
        private boolean valuesEqual(ArrayList<TreeNode> list1, ArrayList<TreeNode> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).val != list2.get(i).val) {
                return false;
            }
        }

        return true;
    }

    public void leaf2(TreeNode ro1) {
        if (ro1 != null) {
            if (ro1.left == null && ro1.right == null) r2.add(ro1);
            leaf2(ro1.left);
            leaf2(ro1.right);
        }
    }

    public void leaf(TreeNode ro1) {
        if (ro1 != null) {
            if (ro1.left == null && ro1.right == null) r1.add(ro1);
            leaf(ro1.left);
            leaf(ro1.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode root2 = new TreeNode(1, new TreeNode(3), new TreeNode(2));

        Solution solution = new Solution();
        boolean result = solution.leafSimilar(root1, root2);

        System.out.println("Are the leaf sequences similar? " + result);
    }
}