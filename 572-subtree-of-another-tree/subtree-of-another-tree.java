
class Solution1 {
    public boolean isSubtree(TreeNode root, TreeNode subroot) {
         if(root==null){
                    return false;
                }
                if(root.val==subroot.val){
                    if(isidentical(root, subroot)) return true;
                }

                return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }
     public static Boolean isidentical(TreeNode root,TreeNode subroot){
                if(root ==null && subroot ==null){
                    return true;
                }
                else if(root ==null || subroot ==null ||root.val!=subroot.val){
                    return false;
                }
                if(!isidentical(root.left, subroot.left)) return false;
                if(!isidentical(root.right, subroot.right)) return false;
                return true;
            }
           
}

class Solution {
    public boolean isSubtree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        
        if (p.val == q.val && isSameTree(p, q)) {
            return true;
        }
        
        return isSubtree(p.left, q) || isSubtree(p.right, q);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
