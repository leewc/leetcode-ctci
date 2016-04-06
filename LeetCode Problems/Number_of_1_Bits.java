public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            if((n & 1) == 1) //if n bitwise 1 == 1 means there's a 1 in the smallest position
                count++;
            n = n >> 1; //right shift by 1 to next bit
        }
        return count;
    }
}