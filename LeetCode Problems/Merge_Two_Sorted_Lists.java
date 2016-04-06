/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        //merge sorted lists.
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        
        //merge remaining if any.
        if(l1 != null)
            cur.next = l1;
        if(l2 != null)
            cur.next = l2;
        
        return head.next;
    }

    public ListNode mergeTwoListsUgly(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode head = null;
        if(l1.val <= l2.val)
        {
            head = l1;
            l1 = l1.next;
        }
        else 
        {
            head = l2;
            l2 = l2.next;
        }
        ListNode result = head;
        ListNode insert = null;
        while(l1 != null && l2 != null)
        {
            if(l1.val <= l2.val)
            {
                insert = l1;
                l1 = l1.next;
            }
            else 
            {
                insert = l2;
                l2 = l2.next;
            }
            head.next = insert;
            head = head.next;
        }
        //remaining
        if(l1 != null)
            head.next = l1;
        else
            head.next = l2;
        
        return result;
    }
}