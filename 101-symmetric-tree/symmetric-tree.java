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
//  public boolean isSymmetric(TreeNode root) 
// {
//     Queue<TreeNode> q=new LinkedList<>();
//     q.add(root.left);
//     q.add(root.right);

//     while(!q.isEmpty()){
//         TreeNode left=q.poll();
//         TreeNode right=q.poll();

//         if(left== null && right ==null){
//              continue;
//         }

//         if(left==null || right == null){
//             return false;
//         }
//         if(left.val!=right.val){
//             return false;
//         }
//         q.add(left.left);
//         q.add(right.right);
//         q.add(left.right);
//         q.add(right.left);
        
//     }
//     return true;
// }

// }

class Solution {
    private HashMap<TreeNode, Boolean> memo = new HashMap<>();
    
    private boolean mir(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        else if (t1 == null || t2 == null) return false;
        
        // Check if the result is already memoized
        if (memo.containsKey(t1) && memo.get(t1) != null) {
            return memo.get(t1);
        }

        boolean result = (t1.val == t2.val) && mir(t1.right, t2.left) && mir(t1.left, t2.right);
        
        // Memoize the result
        memo.put(t1, result);
        
        return result;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return mir(root, root);
    }
}


/*
class Solution {
    static boolean mir( TreeNode t1 , TreeNode t2 )
    {
        if( t1==null && t2== null ) return true;
        else if( t1==null || t2==null ) return false;

        return ( t1.val==t2.val ) && mir( t1.right , t2.left ) && mir( t1.left , t2.right );
    }


    public boolean isSymmetric(TreeNode root) 
    {
        return mir( root , root );
    
    }
}
*/