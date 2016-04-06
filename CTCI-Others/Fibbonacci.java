public class Fibbonacci {
    public static int fibbonacci(int n) {
        if(n == 0 || n == 1 || n == 2) return n;
        
        int[] dp = new int[n+1]; // 0 - 4 
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i - 2];
        }
        return dp[n];
    }
    
    public static void main(String[] argc) {
        System.out.println(fibbonacci((5)));
    }
    
}