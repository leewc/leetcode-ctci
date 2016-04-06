/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode distinct = new ListNode(-1); //fake head
        distinct.next = head;
        
        ListNode current = head;
        ListNode previous = distinct;
        
        while(current != null)
        {
            while(current.next != null && current.val == current.next.val)
            {
                current = current.next;
            }
            
            if(previous.next == current)
            {
                previous = previous.next;
            }
            else
            {
                previous.next = current.next; //snip off non distinct values
            }
            current = current.next; //advance pointer
        }
        
        return distinct.next; 
    }
}