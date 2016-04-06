// Reference: http://www.lifeincode.net/programming/leetcode-zigzag-conversion-java/
public class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || s.length() < 2) return s;
        StringBuilder sb = new StringBuilder();
        
        int step = 2 * numRows - 2;
        for(int i = 0; i < s.length(); i++)
        {
            if(i == 0 || i == numRows - 1)
                for(int j = i; j < s.length(); j += step)
                    sb.append(s.charAt(j));
            else
            {
                int j = i;
                boolean flag = true; //alternating steps
                int step1 = 2 * (numRows - 1 - i);
                int step2 = step - step1;
                while(j < s.length() && sb.length() < s.length())
                {
                    sb.append(s.charAt(j));
                    if(flag)
                        j += step1;
                    else
                        j += step2;
                    flag = !flag;
                }
            }
        }
        return sb.toString();
    }
}