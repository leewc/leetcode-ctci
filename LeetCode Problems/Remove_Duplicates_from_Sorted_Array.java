public class Solution {
    public int removeDuplicates(int[] nums) {
        //initialize head, tail (indices) and length
        int length = nums.length;
        
        if(length == 0 || length == 1)
            return length;
        
        int head = 1;
        int tail = 1;
        int prev = nums[0];
        
        
        while(tail < length)
        {
            if(prev == nums[tail])
            {
                tail++;
            }
            else
            {
                nums[head] = nums[tail];
                prev = nums[head];
                head++;
                tail++;
            }
        }
        
        return head; //since everything after the head is unique
    }
}