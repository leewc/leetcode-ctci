/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
            
        ListNode sorted = new ListNode(-1);
        
        ListNode next = null;
        ListNode prev = sorted;
        ListNode current = head;
        
        while(current != null)
        {
            next = current.next;
            while(prev.next != null && prev.next.val < current.val)
            {
                prev = prev.next;
            }
            //insert the node
            current.next = prev.next;
            prev.next = current;
            
            prev = sorted;
            current = next;
        }
        return sorted.next;
    }

    //same way of doing it, just another attempt
    public ListNode insertionSortList2(ListNode head) {
        if(head == null || head.next == null)
            return head;
            
        ListNode sorted = new ListNode(-1);
        
        ListNode prev = sorted;
        ListNode current = head;
        ListNode next = null;
        
        while(current != null)
        {
            next = current.next;
            while(prev.next != null && current.val > prev.next.val)
            {
                prev = prev.next;
            }
            //insert current
            
            current.next = prev.next;
            prev.next = current;
            
            prev = sorted; //reset pointer to beginning
            current = next; //reset pointer to original current
        }
        return sorted.next;
    }



    //same way of doing it, only with slightly different pointer logic
    public ListNode insertionSortList3(ListNode head) {
        if(head == null || head.next == null)
            return head;
            
        ListNode sorted = new ListNode(0);
        ListNode current = head;
        ListNode prev = sorted;
        ListNode next = null;
        
        while(current != null)
        {
            next = current.next; //hold reference to rest of the list
            
            ListNode pointer = sorted;
            //find place to insert node
            while(prev.next != null && prev.next.val < current.val)
            {
                prev = prev.next;
            }
            //prev.next.val now has a larger value, insert between prev and prev.next
            
            current.next = prev.next;
            prev.next = current;
            prev = sorted;
            current = next;
        }
        return sorted.next;
    }
}