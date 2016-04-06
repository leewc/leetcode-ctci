public class Solution {
    public int search(int[] nums, int target) {
        //one binary search accounting for difference between pivots
        int start = 0; 
        int end = nums.length - 1;
        
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            if(nums[mid] == target)
                return mid;
            
            if(nums[start] <= nums[mid])
            {
                if(target >= nums[start] && target < nums[mid]) //left side
                    end = mid - 1;
                else 
                    start = mid + 1;
            }
            
            if(nums[mid] <= nums[end])
            {
                if(target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else 
                    end = mid - 1;
            }
        }
        return -1;
        
    }
    // public int search(int[] nums, int target) {
    //     int pivot = 1;
    //     while(pivot <= nums.length - 1 && nums[pivot] > nums[pivot -1])
    //         pivot++;
        
    //     //shift back to highest point
    //     pivot--; //
        
    //     //search space is on the left side of pivot
    //     int low = 0;
    //     int high = pivot;
        
    //     //search space is on the right side of pivot
    //     if((pivot != nums.length - 1 || pivot == 0) && nums[0] > target)
    //     {
    //         low = pivot + 1;
    //         high = nums.length - 1;
    //     }
        
    //     // System.out.println("LOW : " + low + ", PIVOT : " + pivot + " , HIGH: " + high);
        
    //     while(low < high)
    //     {
    //         int mid = low + (high - low) / 2;
    //         if(nums[mid] < target)
    //             low = mid + 1;
    //         else 
    //             high = mid;
    //     }
        
        
    //     if(low < nums.length && nums[low] == target) //avoid index out of bounds on unfound number
    //         return low;
    //     return -1;
        
    // }
}