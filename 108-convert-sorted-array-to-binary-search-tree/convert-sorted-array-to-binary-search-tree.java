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
    public TreeNode sortedArrayToBST(int[] nums) {
        List<Integer> elements = new ArrayList<>();
        for (int num : nums) {
            elements.add(num);
        }
        return buildTree(elements, 0, nums.length - 1);
    }

    private TreeNode buildTree(List<Integer> elements, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(elements.get(mid));
        node.left = buildTree(elements, start, mid - 1);
        node.right = buildTree(elements, mid + 1, end);
        return node;
    }
}
