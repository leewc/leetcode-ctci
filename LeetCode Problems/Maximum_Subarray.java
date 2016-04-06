public class Solution {
    
    //O(n) runtime, O(1) memory
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int max = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            //either start over with just the current, or add to what we've seen
            // then compare if result (maxSoFar) is the most we've seen over the past.
            maxSoFar = Math.max(nums[i], maxSoFar + nums[i]); 
            max = Math.max(max, maxSoFar);
        }
        return max;
    }
    
    //O(n) runtime, O(n) memory
    public int maxSubArrayDynamicProgramming(int[] nums) {
        if(nums.length < 1) return 0;
        int[] dp = new int[nums.length];
        
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i < nums.length; i++)
        {
            if (dp[i-1] > 0) //if we have a continuous running total that is not negative
                dp[i] = nums[i] + dp[i-1];
            else //if current > running total
                dp[i] = nums[i]; //subproblem dp[i] = nums[i] + 0;
                
            // this also works since we ensure adding a number doesn't make it go to negative
            // cannot do dp[i-1] + nums[i] > dp[i-1] since we might see another number that's larger when added to the sum later.
            // if(dp[i-1] + nums[i] > 0)
            //     dp[i] = dp[i-1] + nums[i];
            // else if(nums[i] > dp[i-1])
            //     dp[i] = nums[i];
            // else 
            //     dp[i] = 0;

            //update maximum if needed
            if(dp[i] > max)
                max = dp[i];
        }
        return max;
    }
    
    //Naive O(n^2) solution will exceed time limit on large arrays
    public int maxSubArrayNaive(int[] nums) {
        if(nums.length < 1) return 0;
        
        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int j = i + 1;
            while(j < nums.length) {
                cur += nums[j];
                j++;
                if(cur > max)
                    max = cur;
            }
        }
        return max;
    }
}