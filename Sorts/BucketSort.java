import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

//addiional information: http://www.growingwiththeweb.com/2015/06/bucket-sort.html
public class BucketSort {
    
    int N = 5; //default number of buckets
    //can also iterate through the array to find the min/max values and adjust the distribution accordingly
    
    public void bucketSort(int[] array) {
        
        //initialize buckets
        List<List<Integer>> buckets = new ArrayList<List<Integer>>();
        for(int i = 0; i < N; i++)
            buckets.add(new ArrayList<Integer>());
        
        //begin distributing values into buckets
        for(int i : array) {
            int bucketNum = Math.abs(i % N);
            buckets.get(bucketNum).add(i);
        }
        
        //sort each bucket (can use individual sort algorithm)
        for(int i = 0; i < N; i++)
            Collections.sort(buckets.get(i));
        
        //put items in bucket back in array
        int i = 0;
        for(List<Integer> bucket : buckets)
            for(Integer num : bucket)
                array[i++] = num;
    }
    
    public static void main(String[] argc) {
        BucketSort app = new BucketSort();
        int[] array = {1, 4, 6, -1, 0, 2, 5000, -100};
        System.out.println("Before Bucket Sort " + Arrays.toString(array));
        app.bucketSort(array);
        System.out.println("After Bucket Sort " + Arrays.toString(array));
    }
}