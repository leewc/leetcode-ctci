public class Solution {
    public void rotate(int[] nums, int k) {
        
        k %= nums.length;
        int firstPart = nums.length - k;
        
        reverse(nums, 0, firstPart-1);
        reverse(nums, firstPart, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    
    public void reverse(int[] array, int left, int right)
    {
        if(array.length == 1 || left < 0 || right < 0)
            return;
        while(left < right)
        {
            int temp = array[right];
            array[right] = array[left];
            array[left] = temp;
            left++;
            right--;
        }
    }
}