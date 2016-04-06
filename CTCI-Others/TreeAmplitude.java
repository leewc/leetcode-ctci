/*
A binary tree is either an empty tree (represented by an empty pointer) or a node consisting of a single integer value and two binary trees called the left subtree and right subtree.
A binary tree T is given. A path in tree T is a non-empty sequence of nodes of tree T such that each consecutive node in the sequence is a subtree of its preceding node.
A path P in tree T is given. The amplitude of path P is the maximum difference between values of nodes on path P. The amplitude of tree T is the maximum amplitude of paths in T. 
If tree T is empty, then it does not have any paths and its amplitude is assumed to be 0.

For example, consider the following tree T consisting of nine nodes:

              5
           /    \
          8      9
        /  \     /  \ 
      12    2   8    4
               /    /
              2    5


- Sequence [9, 8, 2] is a path in this tree. Sequence [12, 8, 2] is not a path in this tree. Path [5, 8, 2] has amplitude 6. 
- Paths [9, 8, 2] and [5, 8, 12] have amplitude 7. 
- The amplitude of the tree is 7, as no path in it has amplitude greater than [9, 8, 2] or [5, 8, 12].

Assume that the following declarations are given:
class Tree {
  public int x;
  public Tree l;
  public Tree r;
}

Write a function:
    class Solution { public int solution(Tree T); }
that, given a tree T consisting of N nodes, returns the amplitude of T.
For example, given tree T shown in the example above, the function should return 7.
Assume that:
·    N is an integer within the range [0..1,000,000];
·    each element of tree T is an integer within the range [−1,000,000,000..1,000,000,000].
Complexity:
·    expected worst-case time complexity is O(N);
·    expected worst-case space complexity is O(N).

References:
- http://siyang2notleetcode.blogspot.com/2015/02/amplitude-of-tree.html
- https://github.com/faizann/binary_tree_amplitude/blob/master/binary_tree_amplitude.py

*/

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
public class TreeAmplitude {
    
    public static int getAmplitude(TreeNode root){
        if(root == null) return 0;
        int min = root.val;
        int max = root.val;
        
        return dfs(root, min, max);
    }
    
    //subroutine recursively returns the diff (max-min) of each path
    private static int dfs(TreeNode current, int min, int max) {
        if(current == null)
            return max - min;
        
        //assign left max and min as current max and min, update accordingly below
        int leftMax = max;
        int leftMin = min;
        
        if(current.val < min)
            leftMin = current.val;

        if(current.val > max)
            leftMax = current.val;

        //note we technically don't need left and right maximums, but I think it's important to highlight 
        // the distinction we need to calculate/keep track of max-min along different paths recursively
        int rightMax = leftMax;
        int rightMin = leftMin;
        
        //split paths here to calculate (this is the key part of the recursion)
        int leftDiff = dfs(current.left, leftMin, leftMax);
        int rightDiff = dfs(current.right, rightMin, rightMax);
        
        //return the larger difference between left and right paths
        
        return (leftDiff > rightDiff) ? leftDiff : rightDiff;
        
    }
    
    //This does not work since it does not keep track of which path it is on. (left/right paths)
    public static int getAmplitudeWRONG(TreeNode root) {
        if(root == null) return -1;
        
        int max = root.val;
        int min = root.val;
       
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            
            if(current.val > max)
                max = current.val;
            if(current.val < min)
                min = current.val;
            
            if(current.left != null)
                stack.push(current.left);
            if(current.right != null)
                stack.push(current.right);
        }
        return max - min;
    }
    
    public static void main(String[] args) {
        TreeNode t = new TreeNode(5, 
                        new TreeNode(8,
                            new TreeNode(12),
                            new TreeNode(2)),
                        new TreeNode(9,
                            new TreeNode(8,
                                new TreeNode(2),
                                null),
                            new TreeNode(4,
                                new TreeNode(5),
                                null))
                    );
        System.out.println(getAmplitude(t));
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(int val) {
        this.val = val;
    }
    
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}