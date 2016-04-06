public class Solution {
    public int minPathSum(int[][] grid) {
        //left to bottom right, i.e (0,0) -> (grid.length, grid[0].length)
        //only down or right
        int lenx = grid.length;
        int leny = grid[0].length;
        
        int[][] cost = new int[lenx][leny];
        
        //seed first value into cost
        cost[0][0] = grid[0][0];
        //seed first row and first column of values
        for(int i = 1; i < lenx; i++)
            cost[i][0] = cost[i-1][0] + grid[i][0];
        for(int i = 1; i < leny; i++)
            cost[0][i] = cost[0][i - 1] + grid[0][i];
            
        //compute min path values (take min from previous step) add with current step
        for(int i = 1; i < lenx; i++)
            for(int j = 1; j < leny; j++)
                cost[i][j] = grid[i][j] + Math.min(cost[i-1][j], cost[i][j-1]);
        //min to reach end is at the end of array
        return cost[lenx-1][leny-1];
    }
}