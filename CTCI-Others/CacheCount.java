import java.util.*;

public class CacheCount {

    //output miss count
    //Maintain a list of caches, where head is the oldest accessed cache, tail is the newest accessed
    public static int runCache(int[] data, int size) {
        //can use LinkedHashMap for O(1) ordered access too
        List<Integer> cache = new LinkedList<>();
        int missCount = 0;
        int hitCount = 0; //not needed in function
        
        for(int i : data) {
            if(cache.contains(i)) {
                //pop and move to end of list
                cache.remove((Integer) i); //or cache.remove(cache.indexOf(i)); 
                cache.add(i);
                hitCount++;
                System.out.println("Hit " + i);
            }
            else {
                missCount++;
                cache.add(i); //make sure to add and then only evict
                if(cache.size() > size) {
                    int removed = cache.remove(0); //remove oldest cache
                    System.out.println("Miss " + i + " Replace " + removed);
                }
                else //just print that we missted
                    System.out.println("Miss " + i);
            }
        }
        return missCount;
    }
    
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 4, 1};
        System.out.println("Total Cache Miss is : " + runCache(data, 4));
    }
}