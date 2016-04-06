/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode frontier = head;
        ListNode current = head;
        
        //advance frontier ahead by n nodes, so by then current.next is the node to remove.
        for(int i = 0; i < n; i++)
        {
            if(frontier != null)
                frontier = frontier.next;
            else 
                break;
        }
        
        //remove item at front
        if(frontier == null)
        {
            head = head.next;
            return head;
        }
        
        //once the next item is null we're at the end of the list
        while(frontier.next != null) 
        {
            frontier = frontier.next;
            current = current.next;
        }
        
        current.next = current.next.next; //drop node to remove
        
        return head;
        
    }

    //takes O(n) space since we add things into the list
    public ListNode removeNthFromEndInefficient(ListNode head, int n) {
        List<ListNode> ref = new ArrayList<>();
        ListNode current = head;
        while(current != null)
        {
            ref.add(current);
            current = current.next;
        }
        int index = ref.size();
        if(n == 1 && index == 1)
            return null;
        if(n == 1 && index > 1) //last item
            ref.get(index-n-1).next = null;
        else if(n != index) //in between
            ref.get(index-n-1).next = ref.get(index-n+1);
        else //first item
            ref.set(0, ref.get(1));
        return ref.get(0);
    }
}