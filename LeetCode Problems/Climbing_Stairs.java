public class Solution {
    public int climbStairsDP(int n) {
        if(n == 0 || n == 1)
            return n;
        
        int[] dp = new int[n+1];
        //at n = 0 steps there's actually no 0 ways to climb, but for fibbonacci we start with 1, 1.
        dp[0] = 1;
        dp[1] = 1;
        //compute fibbonacci to n steps
        for(int i = 2; i <= n; i++)
            dp[i] = dp[i-1] + dp[i-2];
        
        return dp[n];
    }
    
    //O(1) solution
    public int climbStairs(int n) {
        if(n == 0 || n == 1 || n == 2) return n;
        
        int totalSteps = 0;
        int oneStepBefore = 2;
        int twoStepBefore = 1;
        
        for(int i = 3; i <= n; i++) {
            totalSteps = oneStepBefore + twoStepBefore;
            twoStepBefore = oneStepBefore;
            oneStepBefore = totalSteps;
        }
        return totalSteps;
    }
}