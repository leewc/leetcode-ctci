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
// [1,2,3,null,5,null,null]
// [1,2,3,4,5,6,7,8,9]
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if(root != null) binaryTreePaths(root, new String(), answer);
        return answer;
    }
    
    private void binaryTreePaths(TreeNode root, String path, List<String> answer) {
        if(root.left == null && root.right == null) answer.add(path + root.val);
        if(root.left != null) binaryTreePaths(root.left, path + root.val + "->", answer);
        if(root.right != null) binaryTreePaths(root.right, path + root.val + "->", answer);
    }
    
    //Doesn't work since we need to backtrack and not just clear the entire path.
    private void binaryTreePathsWRONG(TreeNode root, StringBuilder path, List<String> answer) {
        if(root.left == null && root.right == null){
            path.append(root.val);
            answer.add(path.toString());
            path.setLength(0);
        } 
        if(root.left != null) {
            path.append(root.val + "->");
            binaryTreePathsWRONG(root.left, path, answer);
        }
        if(root.right != null) {
            path.append(root.val + "->");
            binaryTreePathsWRONG(root.right, path, answer);
        }
    }
}