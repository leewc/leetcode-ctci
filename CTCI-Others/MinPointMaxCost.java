/*
Reference: http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
Question:
Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path to reach (m, n) from (0, 0).
Each cell of the matrix represents a cost to traverse through that cell. 
Total cost of a path to reach (m, n) is sum of all the costs on that path (including both source and destination). 
You can only traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed.
You may assume that all costs are positive integers.
*/
public class MinPointMaxCost {
    
    public static int maxCostDP(int[][] graph, int x, int y) {
        // int[][] dp = new int[graph.length + 1][graph[0].length + 1];
        int[][] dp = new int[x+1][y+1];
        //seed 0,0 value since we start there.
        dp[0][0] = graph[0][0];
        //also first row and column since we build dp bottom up
        for(int i = 1; i <= x; i++)
            dp[i][0] = dp[i-1][0] + graph[i][0];
        for(int i = 1; i <= y; i++)
            dp[0][i] = dp[0][i-1] + graph[0][i];
        
        int[] min_point = new int[]{0, 0}; //min point along max path (ie coordinates with smallest value along the max path) starts at itself
            
        //since bottom up, the cost of a current cell is the previous + cost of the current cell.
        // different then the recursive one that is top down.
        //also note the <= instead of < since x and y are index postions.
        for(int i = 1; i <= x; i++) {
            for(int j = 1; j <= y; j++) {
                int[] max_idx = max(dp, i-1, j,  i,j-1); //find max index of previous move.
                int max_cost = dp[max_idx[0]][max_idx[1]];
                dp[i][j] = max_cost + graph[i][j];
                
                //update min_point if needed
                if(max_cost < dp[min_point[0]][min_point[1]])
                    min_point = max_idx;
            }
        }
        System.out.println("Min Point along maximum path is: (" + min_point[0] + ", " + min_point[1] + ")");
        return dp[x][y];
    }
    
    private static int[] max(int[][]dp, int x1, int y1, int x2, int y2) {
        if(dp[x1][y1] > dp[x2][y2])
            return new int[]{x1, y1};
        return new int[]{x2, y2};
    }
    
    public static void main(String[] args) {
        int[][] graph = new int[][] { {1, 2, 3},
                                      {4, 8, 2},
                                      {1, 5, 3} };
        
        System.out.println("Max Cost is : " + maxCostDP(graph, 2,2));
    }
}