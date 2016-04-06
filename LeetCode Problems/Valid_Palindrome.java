public class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() < 2) return true; //length 1 or 0
        int start = 0;
        int end = s.length() - 1; //index not length!
        
        while(start < end) {
            //skip all non chars / digits
            while(!Character.isLetterOrDigit(s.charAt(start)) && start < end)
                start++;
            while(!Character.isLetterOrDigit(s.charAt(end)) && start < end)
                end--;
            //compare
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))
                return false;
            //move on
            start++;
            end--;
        }
        return true;
    }
}

//TEST CASES
// ""
// "race a car"
// "hannah"
// "anna"
// "A man, a plan, a canal: Panama"
// ".,"