public class Solution {
    
    ////Method 2: Sort the numbers to ensure dups are right next to each other and generate permutations
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> current = new ArrayList<>();
        
        Arrays.sort(nums);
        permuteUnique(nums, result, current, visited);
        return result;
    }
    
    private void permuteUnique(int[] nums, List<List<Integer>> result, List<Integer> current, boolean[] visited) {
        if(current.size() == nums.length) {
            result.add(new ArrayList<Integer>(current)); //ensure we're adding a new object
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                if(i > 0 && nums[i] == nums[i-1] && visited[i-1])
                    return;

                visited[i] = true;
                current.add(nums[i]);
                permuteUnique(nums, result, current, visited);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
            //else visited, do nothing
        }
    }
    
    ////Method 1: Use a hashset to keep track of permutations. (Slower)
    
    public List<List<Integer>> permuteUniqueHashSet(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        permute2(nums, result, 0);
        return new ArrayList<List<Integer>>(result);
    }
    
    private void permute2(int[] nums, Set<List<Integer>> result, int begin) {
        if(begin == nums.length) {
            List<Integer> list = new ArrayList<>();
            for(int i : nums)
                list.add(i);
            // if(!result.contains(list)) //--don't even need to check since sets replace dups, faster runtime
                result.add(list);
            return;
        }
        
        for(int i = begin; i < nums.length; i++) {
            swap(nums, begin, i);
            permute2(nums, result, begin + 1);
            swap(nums, i, begin);
        }
        return;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}