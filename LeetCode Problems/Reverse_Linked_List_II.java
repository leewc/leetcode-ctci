/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode pre = dummy;
        for(int i = 0; i < m-1; i++) pre = pre.next;
        
        ListNode start = pre.next;
        ListNode after = start.next;
        
        int diff = n - m;
        for(int i = 0; i < diff; i++) {
            start.next = after.next;
            after.next = pre.next;
            pre.next = after;
            after = start.next;
        }
        return dummy.next;
        
    }
    
    // this works but not for case where 1, 2. only 2 items
    // public ListNode reverseBetween(ListNode head, int m, int n) {
    //     if(head == null || head.next == null) return head;
        
    //     ListNode pre = head;
    //     for(int i = 1; i < m-1; i++) pre = pre.next;
        
    //     ListNode start = pre.next;
    //     ListNode after = start.next;
        
    //     int diff = n - m;
    //     for(int i = 0; i < diff; i++) {
    //         start.next = after.next;
    //         after.next = pre.next;
    //         pre.next = after;
    //         after = start.next;
    //     }
    //     return head;
        
    // }
    
    
    // this doesn't work.
    // public ListNode reverseBetween(ListNode head, int m, int n) {
    //     int diff = n - m;
        
    //     if(diff == 0 || head.next == null) return head;
        
    //     ListNode start = head;
    //     ListNode endConnect = null;
    //     while(m > 1) {
    //         endConnect = start;
    //         start = start.next;
    //         m--;
    //     }
    //     //start is now at the node to reverse
    //     //endConnect is one step before, front of reversed list will point here..
    //     endConnect.next = null;

    //     ListNode front = start.next;
    //     ListNode prev = null;
    //     ListNode rest = null;
    //     while(diff != 0) {
    //         rest = front.next;
    //         front.next = prev;
    //         prev = front;
    //         front = rest;
    //         diff--;
    //     }
        
    //     //connect the ends.
    //     start.next = rest;
    //     front.next = endConnect;
        
    //     return head;
    // }
   
}