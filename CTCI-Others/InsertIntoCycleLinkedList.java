class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val) {
        this.val = val;
    }
    
    public ListNode(int val, ListNode next) {
        this.val = val; 
        this.next = next;
    }
}

public class InsertIntoCycleLinkedList {
    
    public static ListNode insertValue(ListNode head, int val) {
        if(head == null) {
            head = new ListNode(val);
            head.next = head; //create a cycle
            return head;
        }
        
        //find the cycle
        ListNode slow = head; //can't start fast as head.next else the math won't work.
        ListNode fast = head;
        
        ListNode pre = null;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow) {
                slow = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                break;
            }
        }
        
        pre = head;
        while(pre.next != slow)
            pre = pre.next;
        
        //pre is now one node before the new cycle, ie the tail.
        ListNode next = pre.next;
        pre.next = new ListNode(val);
        pre.next.next = next;
        
        return head;
    }
    
    public static void main(String[] args) {
        
        //create a cycle list. 
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode (4, new ListNode (5, (new ListNode(6)))))));
        // list.next.next.next.next.next = list.next.next; //this also works. but will infinite loop when printing
        list.next.next.next.next.next.next = list;
        
        insertValue(list, 10);
        
        // detectCycle(list);
        ListNode cur = list;
        do {
            System.out.println(cur.val);
            cur = cur.next;
        } while(cur != list);
    }
}