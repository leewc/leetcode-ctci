public class Solution {
    public int removeElement(int[] nums, int val) {
        int newLength = nums.length;
        int start = 0;
        
        while(start < newLength)
        {
            if(nums[start] == val && nums[newLength - 1] != val)
            {
                //swap the values, decrement newLength
                nums[start] = nums[newLength - 1];
                start++;        //advance start
                newLength--;
            }
            else if(nums[start] == val && nums[newLength - 1] == val)
            {
                //both are the same numbers, don't swap
                newLength--;
            }
            else 
            {
                start++; 
            }
        
        }
        return newLength;
    }
}