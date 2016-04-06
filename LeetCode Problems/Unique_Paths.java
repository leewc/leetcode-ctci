public class Solution {
    public int uniquePaths(int m, int n) {
        //memoization to store possible paths
        int[][] possible = new int[m][n];
        for(int i = 0; i < m; i++)
            possible[i][0] = 1;
        for(int i = 0; i < n; i++)
            possible[0][i] = 1;
        
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                possible[i][j] = possible[i-1][j] + possible[i][j-1];
        
        return possible[m-1][n-1];
    }
}