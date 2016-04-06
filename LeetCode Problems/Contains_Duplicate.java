public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> noDup = new HashSet();
        int i = 0;
        while(i < nums.length)
        {
            if(!noDup.contains(nums[i]))
                noDup.add(nums[i]);
            else
            {
                return true;
            }
            i++;
        }
        return false;
    }
}