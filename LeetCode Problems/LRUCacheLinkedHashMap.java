import java.util.LinkedHashMap;
import java.util.Map;

import java.util.LinkedHashMap;

/* Edge cases to consider
    1. Only one item in the cache of size 1.
    2. Same key different value.
    Must maintain access order: https://docs.oracle.com/javase/7/docs/api/java/util/LinkedHashMap.html
*/

//This is an implementation that uses Javas already provided Data Structures.
public class LRUCacheLinkedHashMap {
    
    final int capacity; //accessed from insided LinkedHashMap, must be final (at least on c9).
    Map<Integer, Integer> lru;
    
    public LRUCache(int cap) {
        this.capacity = cap;

        //16 is the default initial capacity, and 0.75 is the loadFactor
        //third parameter for true means order by access rather than by insertion.
        lru = new LinkedHashMap<Integer, Integer>(16, 0.75f, true) {
                //overload method in LinkedHashMap to start throwing things out
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    // don't want to remove when size is at capacity.
                    // remove when it's above cap
                    return size() > capacity;
                }
        };
    }
    
    public int get(int key) {
        //try to get a value out
        Integer value = lru.get(key);
        if(value != null)
            return value;
        else
            return -1; //value doesn't exist.
    }
    
    public void set(int key, int value) {
        //just put a value in. No need to check if it exists with the use of removeEldestEntry
        lru.put(key, value);
    }

    public static void main(String[] argv) {
        LRUCache cache = new LRUCache(5);
        cache.set(1, 1);
        System.out.println(cache.get(1));
        cache.set(2, 2);
        System.out.println(cache.get(2));
        cache.set(3, 2);
        cache.set(4, 2);
        cache.set(5, 2);
        cache.set(6, 2);
        System.out.println(cache.get(1));
        
    }
}
