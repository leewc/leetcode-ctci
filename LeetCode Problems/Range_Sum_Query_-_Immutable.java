public class NumArray {

    int[] nums;
    
    public NumArray(int[] nums) {
        //since we are only interested in the sum, create a rolling sum
        //index starts at 1 (nothing to add in 0)
        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if(i == 0)
            return nums[j];
        return nums[j] - nums[i - 1]; // -1 since we are inclusive of i. so deduct the sum from before i.
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);