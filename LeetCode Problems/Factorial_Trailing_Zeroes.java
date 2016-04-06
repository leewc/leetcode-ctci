public class Solution {
    public int trailingZeroes(int n) {
        int total = 0;
        
        // use 5 because 10 has 1 trailing zero, calculating mutliples
        // using ints automatically truncate numbers to lower whole number
        while( n >= 1)
        {
            total += n / 5;
            n /= 5;
        }
        return total;
    }
    public int trailingZeroes2(int n) {
        int total = 0;
        int power = 1;
        
        // use 5 because 10 has 1 trailing zero, calculating mutliples
        // using ints automatically truncate numbers to lower whole number
        while( n / Math.pow(5,power) >= 1)
        {
            total += n / Math.pow(5,power);
            power ++;
        }
        return total;
    }
}