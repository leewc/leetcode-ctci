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
        if(head == null || head.next == null)
            return head;

        ListNode pointer = head;
        while(pointer.next != null)
        {
            if(pointer.val == pointer.next.val)
            {
                pointer.next = pointer.next.next;
            }
            else
            {
                pointer = pointer.next;
            }
        }
        return head;
    }
}