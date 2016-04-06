public class MyGCD {
    
    public static int gcdRecursive(int x, int y) {
        if(y == 0)
            return x;
        return gcdRecursive(y, x%y);
    }
    
    public static int gcdIterative(int x, int y) {
        while(x != 0 && y != 0) {
            int z = y; //hold on to original y before we do division
            y = x % y;
            x = z;
        }
        return x + y;
        //one of them is 0, we just need to return the other one that isn't 0, so adding them works.
    }
    
    public static void main(String[] args) {
        int x = 3;
        int y = 18; 
        
        System.out.println(gcdRecursive(x, y));
        System.out.println(gcdIterative(x, y));
    }
}