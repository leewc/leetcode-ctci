/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        //start with current = null, so the loop handles it for us
        ListNode current = null;
        ListNode prev = null;
        ListNode front = head;
        
        while(front != null) {          //this sequence must be exact. Loop ends when there's nothing left.
            current = front;            // 1. set current to front. 
            front = front.next;         // 2. advance front to hold rest of list
            current.next = prev;        // 3. current's next pointer is reversed
            prev = current;             // 4. prev is updated
        }
        return current;                 // loop exits with current being set to the last node.
        
    }

    // ---- OTHER METHODS OF REVERSING THE LIST ---- //
    public ListNode reverseListTWO(ListNode head) {
        if(head == null)
            return head;
    
        ListNode current = head;
        ListNode front = head.next; //holds the existing node references 
        ListNode prev = null;
        current.next = null; //destroy old reference to get single node 

        while(front != null)
        {
            prev = current; //hold previous current
            current = front; //advance current
            
            front = front.next; //advance forward pointer
            current.next = prev; // reverse reference
        }
        
        return current;
    }
    
    public ListNode reverseListTHREE(ListNode head) {
        if(head == null)
            return head;
    
        ListNode current = null;
        ListNode temp = head; 
        ListNode prev = null;
        
        while(temp != null)
        {
            current = temp;
            temp = temp.next;
            current.next = prev;
            prev = current;
            
            //This also works.
            // prev = current;
            // current = temp;
            // temp = temp.next;
            // current.next = prev;
        }
        
        return current;
    }
    
    //recursive
    public ListNode reverseList4(ListNode head)
    {
        //base case 
        if(head == null || head.next == null)
            return head;
        //step, reverse order and move down the list
        else
        {
            ListNode rest = reverseList4(head.next); //recurse down the stack
            
            head.next.next = head; //point back to ourself, aka point node's in front backwards.
            head.next = null;  //destroy old reference
            
            return rest; //needed once we read the end of the list to finish the recursion
        }
    }
    
    public ListNode reverseList5(ListNode head)
    {
        if(head == null || head.next == null)
            return head;
            
        else
        {
            ListNode current = head;
            ListNode second = head.next;
            current.next = null; //destroy old ref
            ListNode rev = reverseList5(second);
            second.next = current;
            return rev;
        }
    }
}