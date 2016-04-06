/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
            
        //needs to be n log n time complexity
        //1. count number of nodes
        ListNode middle = head;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null)
        {
            middle = middle.next;
            fast = fast.next.next;
        }
        
        //recursively do mergesort
        ListNode h2 = sortList(middle.next);
        middle.next = null;
        ListNode h1 = sortList(head);
        return merge(h1, h2);
    }
    
    
    public ListNode merge(ListNode h1, ListNode h2)
    {
        ListNode sorted = new ListNode(-1);
        ListNode current = sorted;
        while(h1 != null && h2 != null)
        {
            if(h1.val < h2.val)
            {
                current.next = h1;
                h1 = h1.next;
            }
            else
            {
                current.next = h2;
                h2 = h2.next;
            }
            current = current.next;
        }
        //copy remaining lists 
        if(h1 != null)
            current.next = h1;
        
        if(h2 != null)
            current.next = h2;
            
        return sorted.next;
    }
}