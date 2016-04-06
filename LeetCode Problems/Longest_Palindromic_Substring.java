// "a"
// "ana"
// "anna"
// "geeksforrofskeeg"
// "abb"
// Note: we can short circuit palindrome checking by only evaluating strings that are potentially larger 
//  than the current palindrome length. 
public class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        int len = s.length();
        String longest = "";
        
        for(int i = 0; i < len; i++) {
            if(isPalindrome(s, i - 1 - max, i)) { //-1 for even case
                longest = s.substring(i - 1 - max, i + 1); // +1 because it's exclusive indexing
                max += 2;
            }
            else if(isPalindrome(s, i - max, i)) {
                longest = s.substring(i - max, i + 1); // +1 because it's exclusive indexing
                max += 1;
            }
        }
        
        return longest;
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        if(start < 0) return false;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++; 
            end--;
        }
        return true;
    }
}