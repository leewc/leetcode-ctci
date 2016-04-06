public class Solution {
    public int mySqrt(int x) {
        //corner case
        if(x <= 1) //aka (x == 0 || x == 1)
            return x; 
        int start = 1;
        int end = x;
        while(start < end)
        {
            int mid = start + (end - start)/2;
            if(mid > x / mid)  // [mid * mid > x] -- might overflow on large numbers
                end = mid;
            else
                start = mid + 1;
        }
        return start - 1; //loop invariant ends when start > end, happens by 1
    }
}