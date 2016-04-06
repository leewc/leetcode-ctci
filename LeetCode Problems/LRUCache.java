import java.util.*;

//an implementation of LRUCache using a hashtable and doubly linked list

public class LRUCache {
    
    int capacity;
    int count;
    Map<Integer, DLNode> cache;
    DLNode head;
    DLNode tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.count = 0;
        
        //pseudo heads to avoid the need to check for nulls
        head = new DLNode(-1, -1);
        tail = new DLNode(-1, -1);
        
        //make sure to change references only after instantiating 
        // compiler did not complain since there was a reference there
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLNode node = cache.get(key);
        if(node == null)
            return -1;
        else {
            moveToFront(node);
            return node.val;
        }
    }
    
    public void set(int key, int value) {
        DLNode node = cache.get(key);
        if(node == null) { //new cache val
            
            DLNode newest = new DLNode(key, value);
            //add to hashtable for O(1) lookup
            cache.put(key, newest);
            addNode(newest);
            count++;

            //check if we are at capacity
            //must add then only check if at capacity to avoid having to deal with edge case where
            // current set is at capacity (else use count == capacity)
            if(count > capacity) {
                DLNode oldest = evictLeastUsed();
                cache.remove(oldest.key);
                count--;
            }    
        }
        else {
            //update value since there's one with the same key
            node.val = value;
            moveToFront(node);
        }
    }
    
    //called each time a cache hit occurs
    private void moveToFront(DLNode node) {
        removeNode(node);
        addNode(node);
    }
    
    private DLNode evictLeastUsed() {
        DLNode oldest = tail.prev;
        //remove references to oldest
        removeNode(oldest);
        return oldest;
    }
    
    private void removeNode(DLNode node) {
        DLNode previous = node.prev;
        DLNode next = node.next;
        
        //remove references to current node
        previous.next = next;
        next.prev = previous;
    }
    
    private void addNode(DLNode node) {
        node.prev = head;
        node.next = head.next;
        
        head.next.prev = node;
        head.next = node;
    }
    
}

//Double Linked Node Class to allow for easy removal and addition of Cache's
class DLNode {
    int key;
    int val;
    DLNode prev;
    DLNode next;
    
    public DLNode(int key, int val) {
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
}