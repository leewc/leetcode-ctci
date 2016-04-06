public class Solution {
    //reversed number is the same if it is a palindrome.
    public boolean isPalindrome(int x) {
        //sanity check
        if(x < 0) return false;
        if(x != 0 && x % 10 == 0) return false; //case: 10 is not a palindrome.
        int rev = 0;
        while(rev < x) {
            rev = rev * 10 + x % 10;
            x = x / 10;
            //keep halving x, while increasing rev, avoid overflow this way.
        }
        return (x == rev || x == rev / 10); //second case for odd palindromes
    }
}