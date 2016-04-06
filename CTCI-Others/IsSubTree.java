class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}


public class IsSubTree {
    
    public static Boolean isSubTree(TreeNode One, TreeNode Two) {
        //find a match first
        if(One == null) return false; //One is larger tree, it's empty now but no subtree
        if(Two == null) return true; //empty tree is always a subtree
        else if(One.val == Two.val)
            if(is_Same_Tree(One, Two)) 
                return true;
        return isSubTree(One.left, Two) || isSubTree(One.right, Two);
    }
    
    
    private static Boolean is_Same_Tree(TreeNode One, TreeNode Two) {
        if(One == null && Two == null) return true;
        else if(One == null || Two == null) return false;
        else if (One.val != Two.val) return false;
        // else if(One != Two || One.left != Two.left || One.right != Two.right)
        else
            return is_Same_Tree(One.left, Two.left) && is_Same_Tree(One.right, Two.right);
    }
    
    
    public static void main(String[] args) {
        TreeNode One = new TreeNode(5);
        One.left = new TreeNode(3);
        One.right = new TreeNode (10);
        One.left.left = new TreeNode(1);
        One.left.right = new TreeNode(2);
        One.right.left = new TreeNode(7);
        One.right.right = new TreeNode(15);
        
        TreeNode Two = new TreeNode (10);
        Two.left = new TreeNode(7);
        Two.right = new TreeNode(15);
        
        System.out.println("IsSubTree: " + isSubTree(One,Two));
    }
}