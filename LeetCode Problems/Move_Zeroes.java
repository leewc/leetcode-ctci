public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        int insert = 0;
        for(int num: nums)
        {
            if(num != 0)
            {
                nums[insert] = num;
                insert++;
            }
        }
        while(insert < nums.length)
        {
            nums[insert] = 0;
            insert++;
        }
    }
    public void moveZeroes2(int[] nums) {
        int i = 0;
        while(i < nums.length)
        {
            if(nums[i] == 0)
            {
                int next = i + 1; //find the next non zero and move it over
                while(next < nums.length && nums[next] == 0)
                    next++;
                
                if(i < nums.length && next < nums.length)
                {
                    nums[i] = nums[next];
                    nums[next] = 0;
                }
            }
        i++;
        }
    }
}