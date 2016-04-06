/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// []
// [1,2,null,3]
// [5,4,7,3,null,2,null,-1,null,9]
// [1,1]
// [10,5,15,null,null,6,20]
// [8,3,10, 1,6, null, 4]
// [5,2,7]
// [8,3,10,1,6,null,14]
// http://articles.leetcode.com/2010/09/determine-if-binary-tree-is-binary.html
// for why the naive soln doesn't work
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    //recursive function that performs evaluations based on max and min nodes
    //if current node does not fit the range return false;
    public boolean isValidBST(TreeNode current, TreeNode min, TreeNode max)
    {
        if (current == null) return true;
        if (max != null && current.val >= max.val) return false;
        if (min != null && current.val <= min.val) return false;
        return isValidBST(current.left, min, current) && isValidBST(current.right, current, max);
    }

    public boolean isValidBST_Iterative(TreeNode root) {
        if(root == null)
            return true;
            
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode prev = null;
        
        while(!stack.isEmpty() || current != null)
        {
            if(current != null)
            {
                stack.push(current);
                current = current.left; //go down BST where there is lesser value
            }
            else
            {
                TreeNode node = stack.pop(); //pop from the stack
                if(prev != null && prev.val >= node.val) //previous (aka higher/right nodes must always have larger value)
                    return false;
                prev = node; //set current node as the previous node
                current = node.right; //switch to right side
            }
        }
        return true;
    }
}