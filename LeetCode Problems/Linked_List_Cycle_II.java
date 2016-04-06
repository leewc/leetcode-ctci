/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast.next == slow.next) //cycle, since fast has caught up with slow.
            {
                //return node where cycle begins
                ListNode begin = head;
                while(begin != slow)
                {
                    begin = begin.next;
                    slow = slow.next;
                }
                return begin;
            }
        }
        return null;
    }

    //checking for cycle by comparing if fast == slow and not their .next
    public ListNode detectCycle2(ListNode head) {
        if(head == null)
            return null;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) //cycle, since fast has caught up with slow.
            {
                //return node where cycle begins
                ListNode begin = head;
                while(begin != slow)
                {
                    begin = begin.next;
                    slow = slow.next;
                }
                return begin;
            }
        }
        return null;
    }
}