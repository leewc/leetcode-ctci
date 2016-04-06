/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    //Longer but easier to understand
    public void deleteNode2(ListNode node) {
        ListNode remaining = node.next;
        if(remaining != null)
        {
            node.val = remaining.val;
            node.next = remaining.next;
        }
}