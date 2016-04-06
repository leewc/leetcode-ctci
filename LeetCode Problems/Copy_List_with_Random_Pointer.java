/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        
        //copy all nodes
        RandomListNode pointer = head;
        while(pointer != null)
        {
            map.put(pointer, new RandomListNode(pointer.label)); //store as new Nodes for deep copies
            pointer  = pointer.next;
        }
        
        //assign next and random values
        pointer = head;
        while(pointer != null)
        {
            map.get(pointer).next = map.get(pointer.next);
            map.get(pointer).random = map.get(pointer.random);
            pointer = pointer.next;
        }
        
        return map.get(head);
    }
}