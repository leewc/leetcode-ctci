// ""
// " "
// "+"
// "3"
// "3/4"
// "3+"
// "3+"
// "4-+"
// "-4"
// "--4"
// "+5"
// "2147483647"
// "-2147483647"
// "abc"

public class Solution {
    public int myAtoi(String str) {
        //get rid of whitespace
        if(str == null) return 0;
        
        str = str.trim();
        int length = str.length();
        
        int sign = 1;
        int index = 0;
        int total = 0;
        if(length == 0) return 0;

        if(str.charAt(0) == '-' || str.charAt(0) == '+')
        {
            sign = (str.charAt(0) == '+') ? 1 : -1;
            index++;
        }
        
        while(index < length)
        {
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;
            
            //10 since 0-9 .. 
            if((total > (Integer.MAX_VALUE - digit)/10) || total < (Integer.MIN_VALUE + digit)/10 )
            {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            total = total * 10 + digit;
            index++;
        }
        return total * sign;
    }

    // Less elegant and efficient
    public int myAtoiUgly(String str) {
        //get rid of whitespace
        str = str.trim();
        int length = str.length();
        int end = 0;
        
        if(length == 0) return 0;
        
        //check if minus exists, ignore + since it's the same thing
        boolean hasSign = false;
        if(str.charAt(0) == '-' || str.charAt(0) == '+')
        {
            hasSign = true;
            end = 1;
        }
        
        if(hasSign && length > 1 && (str.charAt(1) < '0' || str.charAt(1) > '9'))
            return 0;
        else if(!hasSign && (str.charAt(0) < '0' || str.charAt(0) > '9'))
            return 0;

        
        while(end + 1 < length  && str.charAt(end + 1) >= '0' && str.charAt(end + 1) <= '9')
            end += 1;
        
        if(end >= length || (str.charAt(end) < '0' && str.charAt(end) > '9'))
            return 0;
        
        try 
        {
            return Integer.parseInt(str.substring(0, end + 1));
        }
        catch(NumberFormatException n)
        {
            if(hasSign && str.charAt(0) == '-') return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
    }
}