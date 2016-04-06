public class Solution {
    
    //O(n) solution using HashMap
    //Store previously seen numbers and their index
    //Retrieve indexes with a key of (target - number) since we want a value that ensures current number + value = target
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i]))
                return new int[] {map.get(target - nums[i]), i };
            else
                map.put(nums[i], i);
        }
        return new int[]{0};
    }
    
    // Bruteforce O(n^2) solution
    // public int[] twoSum(int[] nums, int target) {
    //     for(int i = 0; i < nums.length; i++) {
    //         for(int j = 1; j < nums.length; j++) {
    //             if(nums[i] + nums[j] == target)
    //                 return new int[]{i, j};
    //         }
    //     }
    //     return new int[]{0};
    // }
}