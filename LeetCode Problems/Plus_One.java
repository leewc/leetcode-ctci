public class Solution {
    public int[] plusOne(int[] digits) {
        boolean carry = false;
        if(digits[digits.length-1] == 9)
        {
            carry = true;
        }
        else
            digits[digits.length-1]++;
            
        if(carry)
        {
            //test if we need to allocate a new int array
            if(digits[0] == 9)
            {
                int[] arr = new int[digits.length+1];
                System.arraycopy(digits, 0, arr, 1, digits.length);
                digits = arr;
            }
            
            int i = digits.length-1;
            while(i >= 0)
            {
                if(digits[i] == 9)
                    digits[i] = 0;
                else
                {
                    digits[i]++;
                    break;
                }
                i--;
            }
        }
        return digits;
    }
}