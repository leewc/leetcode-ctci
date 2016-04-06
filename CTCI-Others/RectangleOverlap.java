// Find if two rectangles overlap in Cartesian space
public class RectangleOverlap {
    // Notice how we only need 2 points to compare the entire rectangle
    
    public static boolean isOverlap(Rectangle A, Rectangle B) {
        return ! ( B.x2 < A.x3 ||
                   B.x3 > A.x2 ||
                   B.y2 < A.y3 ||
                   B.y3 > A.y2
                 );
    }
    
    //this is wrong
    // public static boolean isOverlap(Rectangle a, Rectangle b) {
    //     if(b.y2 < a.y2 && b.y2 > a.y3) return true;
    //     if(b.y3 < a.y2 && b.y3 > a.y3) return true;
    //     if(b.x2 < a.x2 && b.x2 > a.x3) return true;
    //     if(b.x3 < a.x2 && b.x3 > a.y3) return true;
    //     return false;
    // }
    
    public static void main(String[] argc) {
        Rectangle a = new Rectangle(2,3,  5,3,  2,0,  5,0);
        Rectangle b = new Rectangle(1,7,  10,7,  1,1,  10,1);
        Rectangle c = new Rectangle(2,5,  10,5,  2,10,  5,10);
        
        Rectangle d = new Rectangle(0,0,  5,5,  1,0,  0,0);
        Rectangle e = new Rectangle(0,0,  6,4,  0,1,  0,0);
        
        System.out.println("Do rectangles overlap : " + isOverlap(a,b));
        System.out.println("Do rectangles overlap : " + isOverlap(a,c));
        System.out.println("Do rectangles overlap : " + isOverlap(d,e));
    }
}

class Rectangle {
    int x1, y1, x2, y2, x3, y3, x4, y4;
    public Rectangle(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
    }
}