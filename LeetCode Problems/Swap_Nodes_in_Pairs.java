/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        
        while(current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next; //or first.next
            current.next = second;
            first.next = second.next;
            second.next = first;
            
            current = first;
        }
        
        
        return dummy.next;
    }
    
    //copy of previous code that doesn't work (too many pointers to keep track of)
    public ListNode BADswapPairs(ListNode head) {
        if(head == null) return null;
        
        ListNode current = head;
        ListNode prev = null;
        ListNode next = head.next;
        head = next;

        while(current != null && next != null) {
             ListNode rest = next.next;
            
            //move pointers for next pair
            prev = next;
            current = rest;
            if(current != null)
                next = current.next;
                
           //point back
            next.next = current;
            //update refs
            if(prev != null)
                prev.next = next;
            current.next = rest;
            
            
        }
        return head;
        
    }
}