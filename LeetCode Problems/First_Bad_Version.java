/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    // find out the first bad one.
    public int firstBadVersion(int n) {
        int start = 1; //1 ... n
        int end = n;
        while(start < end)
        {
            int mid = start + (end - start)/2;
            if(isBadVersion(mid))
                end = mid;
            else 
                start = mid + 1;
        }
        return start; //since we need to find the first bad one.
    }
}