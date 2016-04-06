public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        permute(nums, result, 0);
        return result;
    }
    
    private void permute(int[] nums, List<List<Integer>> result, int begin) {
        if(begin == nums.length) {
            //this is a permutation we want.
            List<Integer> list = new ArrayList<Integer>(nums.length);
            for(int i : nums)
                list.add(i);
            
            result.add(list);
            return;
        }
        for(int i = begin; i < nums.length; i++) { //not starting at int i = 0
            swap(nums, begin, i); //also begin, i not 0 and i 
            permute(nums, result, begin + 1);
            //reset
            swap(nums, i, begin);
        }
    }
    
    private void swap(int[] nums, int begin, int end) {
        int temp = nums[begin];
        nums[begin] = nums[end];
        nums[end] = temp;
    }
}