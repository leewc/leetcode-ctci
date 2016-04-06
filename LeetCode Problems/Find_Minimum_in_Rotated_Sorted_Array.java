public class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        //also accounts for size 1 since high will == low
        while(low < high)
        {
            //case: array is not rotated
            if(nums[low] < nums[high])
                return nums[low];
            
            int mid = low + (high - low)/2;
            
            //max on right, min on left part 
            if(nums[mid] < nums[high]) 
                high = mid;
            
            //max on left, min on right part
            else
                low = mid + 1;
        }
        return nums[low];
    }
}