class Solution1 {
    public boolean isEvenOddTree(TreeNode root) {
        int depth = findDepth(root);
        if (depth == 0)
            return true;
        al = new int[depth];
        for (int i = 1; i < depth; i += 2) {
            al[i] = Integer.MAX_VALUE;
        }
        return isEvenOddTree_(root, 0);
    }

    public static int[] al;

    public static int findDepth(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(findDepth(root.left), findDepth(root.right));
    }

    public static boolean isEvenOddTree_(TreeNode root, int level) {
        if (root == null || level < 0)
            return true;

        if (level % 2 == 0) {
            if (root.val % 2 == 0 || al[level] >= root.val) {
                return false;
            }
            al[level] = root.val;
        }
        if (level % 2 == 1) {
            if (root.val % 2 == 1 || al[level] <= root.val) {
                return false;
            }
            al[level] = root.val;
        }
        return isEvenOddTree_(root.left, level + 1) && isEvenOddTree_(root.right, level + 1);
    }
}

 

class Solution {
    
    public boolean isEvenOddTree(TreeNode root) {
        HashMap<Integer, Integer> levels = new HashMap<>();
        return checkEvenOdd(root, levels, 0);
    }
    
    public boolean checkEvenOdd(TreeNode root, HashMap<Integer, Integer> levels, int level){
        if(root == null) return true;
        
        // Checking if value is correct at each level
        if(root.val % 2 == level % 2) return false;
        
        // Checking order at each level if there was a previous entry
        if(levels.containsKey(level)){
            if(level % 2 == 0 && levels.get(level) >= root.val){
                return false;
            } else if(level % 2 == 1 && levels.get(level) <= root.val){
                return false;
            }
        }
        
        // Add last visited node at that level to hashmap
        levels.put(level, root.val);           
        
        return checkEvenOdd(root.left, levels, level + 1) && checkEvenOdd(root.right, levels, level + 1);
    }
}
