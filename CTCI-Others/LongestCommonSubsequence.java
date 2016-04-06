//Reference: http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
//No need to import math library for Math.max! 
import java.util.Arrays;
public class LongestCommonSubsequence {
    
    // Runtime for dynamic programming implementation is O(m + n) 
    public static int LCSDp(String X, String Y, int lenX, int lenY) {
        //store previously computed lengths in DP
        // need to build dp bottom up for memoizing, rather than recurse top down
        // need +1 as the final length will be at dp[lenX+1][lenY+1]
        //    this avoids handling cases where lenX-1 == -1, and having a guard where if xi, yi is 0 just do nothing (i.e set to 0 again)  
        int[][] dp = new int[lenX + 1][lenY + 1];
        
        //note the less than equals!
        for(int xi = 0; xi <= lenX; xi++) {
            for(int yi = 0; yi <= lenY; yi++) {
                if(xi == 0 || yi == 0)
                    dp[xi][yi] = 0; 
                else if(X.charAt(xi - 1) == Y.charAt(yi - 1))
                    dp[xi][yi] += dp[xi-1][yi-1] + 1;
                else
                    dp[xi][yi] = Math.max(dp[xi-1][yi], dp[xi][yi - 1]);
            }
        }
        
        // for(int[] a : dp)
        //     System.out.println(Arrays.toString(a));
        return dp[lenX][lenY];
    }

    
    // Runtime for recursive implementation is 2^n 
    public static int LCSRec(String X, String Y, int lenX, int lenY) {
        if(lenX == 0 || lenY == 0)
            return 0;
        else if(X.charAt(lenX - 1) == Y.charAt(lenY - 1)) //we have a match. hence + 1 and recurse
            return 1 + LCSRec(X.substring(0, lenX - 1), Y.substring(0, lenY - 1), lenX - 1, lenY -1);
        else {
            int shorterX = LCSRec(X.substring(0, lenX - 1), Y.substring(0, lenY), lenX - 1, lenY);
            int shorterY = LCSRec(X.substring(0, lenX), Y.substring(0, lenY - 1), lenX, lenY - 1);
            return Math.max(shorterX, shorterY);
        }
    }


    public static void main(String[] argc) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        
        System.out.println("Recursion: Length of LCS is: " + LCSRec(X, Y, X.length(), Y.length())); 
        
        System.out.println("Dynamic Programming: Length of LCS is: " + LCSDp(X, Y, X.length(), Y.length())); 
        
    }
    
    public static int LCSDpWRONG(String x, String Y, int lenX, int lenY) {
        //store previously computed lengths in DP
        int[][] dp = new int[lenX][lenY];
                
        //decrement lengths for use as index
        lenX--;
        lenY--;
        int max = 0;
        
        while(lenX != 0 && lenY != 0) {
            int val = dp[lenX][lenY];
            // System.out.print(val + " " + x.charAt(lenX) + " " + Y.charAt(lenY));
            if(val > max)
                max = val;
            else if(x.charAt(lenX) == Y.charAt(lenY))
                dp[lenX][lenY] += 1;
            else {
                //find compare both chars at diff indexes and save into dp
                if(x.charAt(lenX) == Y.charAt(lenY - 1))
                    dp[lenX][lenY - 1] += 1;
                if(x.charAt(lenX - 1) == Y.charAt(lenY))
                    dp[lenX - 1][lenY] += 1;
            }
            lenX--;
            lenY--;
        }
        for(int[] a : dp)
            System.out.println(Arrays.toString(a));
        return max;
    }
}