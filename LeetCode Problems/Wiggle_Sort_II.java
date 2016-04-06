public class Solution {
    
    public void wiggleSort(int[] nums) {
        int[] sorted = new int[nums.length];
        System.arraycopy(nums, 0, sorted, 0, nums.length);
        
        Arrays.sort(sorted);
        
        int j = 0; //first half
        int k = (nums.length - 1)/2 + 1; //second half 
        for(int i = nums.length - 1; i >= 0; i--) { //start from end since it's variable length, affecting the entire wiggling
            if(i % 2 == 0) {
                nums[i] = sorted[j];
                j++;
            }
            else {
                nums[i] = sorted[k];
                k++;
            }
        }
 
    }
    
    
    //works only if the requirement is nums[0] <= nums[1] >= nums[2] <= nums[3]
    public void wiggleSortONE(int[] nums) {
        // start at pos 1
        // all our odd numbers must be more than the previous number, ie i > i-1
        // all our even numbers must be less than the previous number, ie i < i - 1
        // provide conditions in which swapping must occur
        for(int i = 1; i < nums.length; i ++) {
            if(i % 2 == 1 && nums[i] <= nums[i - 1] 
                ||
               i % 2 == 0 && nums[i] >= nums[i - 1]
              ) 
              {
                  int temp = nums[i];
                  nums[i] = nums[i - 1];
                  nums[i - 1] = temp;
              }
        }
    }
}