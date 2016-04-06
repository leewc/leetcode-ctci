public class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        if(length < 2)
            return s;
        
        String longestPalindrome = "";
        int i = 1;
        
        while(i < length)
        {
            String palindrome = ""; //avoid nulls with empty string
            if(s.charAt(i-1) == s.charAt(i)) // try even case
                palindrome = getPalindrome(s, i-1, i, length);

            if((i-2 >= 0 && s.charAt(i-2) == s.charAt(i))) //try odd case
            {
                String odd = getPalindrome(s, i-2, i, length);
                if(odd.length() > palindrome.length())
                    palindrome = odd;
            }
            
            if(longestPalindrome.length() < palindrome.length())
                longestPalindrome = palindrome;
            
            i++;
        }
        return longestPalindrome;
    }
    
    public String getPalindrome(String s, int left, int right, int length)
    {
        while(left >= 0 && right < length)
        {
            if(s.charAt(left) == s.charAt(right))
            {
                left--;
                right++;
            }
            else 
                break;
        }
        //set indexes back to previous value. 
        // (I could have not decremented right since substring requires index + 1, but I did so for completeness)
        // apparently using more variables and not incrementing them is faster, reducing variables and using existing ones 
        // increased runtime from 36 to 43ms
        left++;
        right--;
        return s.substring(left, right+1);
    }
}