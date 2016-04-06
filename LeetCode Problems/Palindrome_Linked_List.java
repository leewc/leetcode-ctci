/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        //a palindrome if it's empty or only one item
        if(head == null || head.next == null)
            return true;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        //odd number of elements, shift slow
        if(fast != null)
            slow = slow.next;
        slow = reverse(slow);
        
        ListNode restore = slow; //to restore the list at the end
        ListNode pointer = head; //compare first part start from the beginning
        while(slow != null && slow.val == pointer.val)
        {
            slow = slow.next;
            pointer = pointer.next;
        }
        
        restore = reverse(restore);
        return slow == null; //true: is a palindrome (since we the loop ended nicely)
    }
    
    public ListNode reverse(ListNode head)
    {
        ListNode current = null;
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null)
        {
            current = temp;
            temp = temp.next;
            current.next = prev;
            prev = current;
        }
        return current;
    }
}