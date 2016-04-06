// Find the K closest points to the origin in 2D plane, given an array containing N points.
// You can assume K is much smaller than N and N is very large.
// e.g: [(0,1), (1,0), (2,2), (5,3), (5,5)] k = 2 returns (0,1) (1,0)

import java.util.PriorityQueue;
import java.util.Comparator;


//protected class
class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class KNearestPoints {
    
    //can also put this into point by implementing comparable. 
    private static Comparator<Point> pointsComparable() {
        return new Comparator<Point>() {
                public int compare(Point a, Point b) {
                    int distA = a.x * a.x + a.y * a.y;
                    int distB = b.x * b.x + b.y * b.y;
                    if(distA < distB) return -1;        //return -1 if less 
                    else if(distA > distB) return 1;    //return 1 if more
                    else return 0;
                }
        };
    }
    
    public static Point[] KNearestPoints(Point[] arr, int k) {
        //minheap
        PriorityQueue<Point> queue = new PriorityQueue<>(k, pointsComparable());
        Point[] nearest = new Point[k];
        for(int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        
        for(int i = 0; i < k; i++) {
            nearest[i] = queue.poll();
        }
        return nearest;
    }
    
    
    public static void main(String[] args) {
        Point[] pArray = new Point[]{ new Point(0,1), new Point(1,0), new Point(2,2), new Point(5,3), new Point(5,5) };
        Point[] nearest = KNearestPoints(pArray, 2);
        
        System.out.println("K Nearest Points: ");
        for(Point p : nearest)
            System.out.println("(" + p.x + ", " + p.y + ")");
    }
}