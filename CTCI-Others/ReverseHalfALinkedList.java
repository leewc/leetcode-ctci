class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val, ListNode next) {
        this.val = val; 
        this.next = next;
    }
}

public class ReverseHalfALinkedList {
    
    public static ListNode reverseHalf(ListNode head) {
        ListNode current = head;
        ListNode fast = head;
        ListNode prev = null;

        
        while(fast.next != null && fast.next.next != null) {
            prev = current;
            current = current.next;
            fast = fast.next.next;
        }
        
        if(fast.next != null){ //odd number of elements
            prev = current;
            current = current.next;
        }
        
        ListNode last = null;
        while(current != null) {
            ListNode rest = current.next;
            current.next = last;
            last = current;
            current = rest;
        }
        prev.next = last; //destroy reference (can first set to null also.)
        
        return head;
    }
    
    
    public static void main(String[] args) {
        //create a linked list. 
        ListNode listEven = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode (4, new ListNode (5, (new ListNode(6, null)))))));
        ListNode listOdd = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode (4, new ListNode (5, null)))));
        
        // listEven = reverseHalf(listEven);
        reverseHalf(listEven);
        // listOdd = reverseHalf(listOdd);
        reverseHalf(listOdd);
        
        print(listEven);
        print(listOdd);
    }
    
    public static void print(ListNode head) {
        ListNode cur = head;
        while(cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println();
    }
}