/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> order = new LinkedList<>();
        if(root == null)
            return order;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int depth = queue.size();
            List<Integer> level = new LinkedList<>();
            for(int i = 0; i < depth; i++)
            {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            order.add(level);
        }
        return order;
    }

//     Another less smarter way of doing it.
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> order = new LinkedList<>();
//         if(root == null) 
//             return order;
//         Queue<NodeSet> queue = new LinkedList<>();
//         queue.add(new NodeSet(root, 0));
//         int currentDepth = 0;
        
//         LinkedList<Integer> level = new LinkedList<>();
//         while(!queue.isEmpty())
//         {
//             NodeSet ns = queue.remove();
//             if(currentDepth != ns.depth)
//             {
//                 currentDepth = ns.depth;
//                 order.add(level);
//                 level = new LinkedList<>();
//             }
            
//             level.add(ns.node.val);
            
//             //put in any other possible nodes
//             if(ns.node.left != null)
//                 queue.add(new NodeSet(ns.node.left, currentDepth + 1));
//             if(ns.node.right != null)
//                 queue.add(new NodeSet(ns.node.right, currentDepth + 1));
//         }
//         //add the leaves
//         order.add(level);
//         return order;
//     }
// }

// class NodeSet {
//     int depth;
//     TreeNode node;
    
//     NodeSet(TreeNode node, int depth)
//     {
//         this.node = node;
//         this.depth = depth;
//     }
}