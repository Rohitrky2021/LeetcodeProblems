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
// class Solution {
//     public List<TreeNode> allPossibleFBT(int n) {
        
//     }
// }
class Solution {

 public List<TreeNode> allPossibleFBT(int n) {


        if(n%2==0){
            return new ArrayList<>();
        }
        return helper(n);


        
    }
    public List<TreeNode> helper(int n) {
        if(n==1){
           return Arrays.asList(new TreeNode(0));

        }
        List<TreeNode> ans =new ArrayList<>();
        for (int i = 1; i < n; i+=2) {
            
            List<TreeNode> left = helper(n-i-1) ;
            List<TreeNode> right= helper(i) ;

            for(TreeNode l:left){
                for(TreeNode r:right){
                    // TreeNode c=new TreeNode(0,l.left,r.right);
                    TreeNode root=new TreeNode(0,l,r);
                    // root.left=l;
                    // root.right=r;
                    ans.add(root);



                }
            }
        }
        return ans;


        
    }
    }