public class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length + 1][2]; //0 if we rob current house, 1 if we don't
        for(int i = 1; i < nums.length + 1; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]); //find max between previous value of robbing vs not robbing and assign
            dp[i][1] = dp[i-1][0] + nums[i - 1]; //don't rob current house, so rob prev house
            
        }
        //sum will be at the end of the array. which we need +1 since it's checking previous
        int max = 0;
        if(dp[length][0] > dp[length][1]) //series of robbing current house is more
            max = dp[length][0];
        else
            max = dp[length][1];
        
        return max;
    }
    
    //Solution also from the forums
    public int rob2(int[] nums) {
        int ifRobPrevious = 0;
        int ifDidntRobPrevious = 0;
        
        //go through all items, maintain 2 counts if we rob current, if we didn't rob current.
        for(int i = 0; i < nums.length; i++) {
            int currentRobbed = ifDidntRobPrevious + nums[i]; //can't rob previous, add that value.
            int currentNotRobbed = Math.max(ifDidntRobPrevious, ifRobPrevious); 
            //pick higher among 2. since not robbing current, counter maintains max of previous cell robbed and not robbed.  
            
            //update values, so next round can use data on if we robbed current (now prev), or not.
            ifRobPrevious = currentRobbed;
            ifDidntRobPrevious = currentNotRobbed;
        }
        
        return Math.max(ifRobPrevious, ifDidntRobPrevious);
    }
}
