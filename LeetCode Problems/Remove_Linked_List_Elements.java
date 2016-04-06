/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //recursive
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;
        
        else if(head.val == val)
                return removeElements(head.next, val);
        
        head.next = removeElements(head.next,val);    
        return head;
    }



    public ListNode removeElementsIterative(ListNode head, int val) {
        
        //drop all nodes in front while they have values we don't want
        while(head != null && head.val == val)
            head = head.next;
        
        //check if there's nothing else in the list
        if(head == null)
        {
            return head;
        }
        
        //remaining list 
        ListNode current = head;
        ListNode front = head.next;
        while(front != null)
        {
            if(front.val != val)
            {
                //keep the value by advancing current
                current = current.next;
            }
            else
            {
                //skip a node by dropping it
                current.next = front.next;
            }
            front = front.next; //advance pointer
        }
        return head;
    }
}