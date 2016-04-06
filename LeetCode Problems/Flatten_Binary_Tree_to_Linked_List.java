/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // credits: https://leetcode.com/discuss/30719/my-short-post-order-traversal-java-solution-for-share
public class Solution {
    public void flatten(TreeNode root) {
        flatten(root, null);
    }
    
    private TreeNode flatten(TreeNode root, TreeNode prev) {
        if(root == null)
            return prev;

        prev = flatten(root.right, prev);
        prev = flatten(root.left, prev);
        
        root.right = prev;
        root.left = null;
        
        prev = root;
        return prev;
        // return root; //alternatively just this
    }
}