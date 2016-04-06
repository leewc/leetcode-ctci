public class Solution {
    
    public int lengthOfLIS(int[] nums) {
        if(nums.length < 2)
            return nums.length; 
        
        int len = 1; //the minimum LIS is 1
        int[] subseq = new int[nums.length];
        subseq[0] = nums[0];
        
        for(int i = 1; i < nums.length; i++)
        {
            if (nums[i] <  subseq[0]) //new smallest value 
                subseq[0] = nums[i];
            else if(nums[i] > subseq[len-1]) //extend largest subsequence
            {
                subseq[len] = nums[i];
                len++;
            }
            else 
            // A[i] wants to be current end candidate of an existing
            // subsequence. It will replace ceil value in subseq
            {
                //System.out.println("Before: " + Arrays.toString(subseq));
                subseq[binarySearch(subseq, 0, len-1, nums[i])] = nums[i];
                //System.out.println("After: " + Arrays.toString(subseq));
            }
        }
        //System.out.println("Final: " + Arrays.toString(subseq));
        
        return len;
    }
    
    public int binarySearch(int[] nums, int start, int end, int target)
    {
        while(start < end)
        {
            int mid = start + (end - start) / 2;
            if(nums[mid] < target)
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }
    
    //simpler version without binary search
    public int lengthOfLISWithoutBinarySearch(int[] nums) {
        if(nums.length < 2)
            return nums.length;
        
        //use dynamic programming, initially the min longest is 1
        //dp holds the length of longest subseq till that point
        int[] dp = new int[nums.length];
        for(int i = 0; i < dp.length; i++)
            dp[i] = 1;
        
        for(int i = 1; i < nums.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[j] < nums[i]) //we have increasing subsequence
                    //check if incrementing the value will make a difference
                    if(dp[j] + 1 > dp[i])
                        dp[i] = dp[j] + 1;
            }
            //for loops allow j to be reset when it equals to i, hence no need to manually increment i and j
        }
        int longest = 0;
        for(int i = 0; i < dp.length; i++)
            longest = Math.max(longest, dp[i]);
        return longest;
    }
}