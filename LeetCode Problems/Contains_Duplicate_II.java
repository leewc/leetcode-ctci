public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(i > k)
                set.remove(nums[i-k-1]); //sliding window, remove the last number
            if(!set.add(nums[i]))
                return true;
        }
        return false;
    }
    // public boolean containsNearbyDuplicate(int[] nums, int k) {
    //     int i = 0;
            
    //     while(i < nums.length)
    //     {
    //         for(int j = i + 1; j - i <= k; j++)
    //         {
    //             if(j < nums.length && nums[i] == nums[j])
    //                 return true;
    //         }
    //         i += k;
            
    //         if(k == 0)
    //             i++;
    //     }
    //     return false;
    // }
}