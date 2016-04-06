public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        
        int low = 0;
        int high = nums.length - 1;
        
        //employ 2 binary searches, one biased on left side the other biased to the right side
        
        //find left range
        while(low < high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid] < target)
                low = mid + 1; //on right side of search space
            else
                high = mid; //on left side of search space
        }
        
        if(nums[low] != target)
            return result;
        result[0] = low;    
        
        //find right range with bias
        high = nums.length - 1;
        while(low < high)
        {
            int mid = low + (high - low + 1) /2;
            if(nums[mid] > target)
                high = mid - 1; //on left side of search space
            else 
                low = mid; //on right side of search space
        }
        
        result[1] = high;
        
        return result;
    }
}