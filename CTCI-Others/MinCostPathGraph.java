/*
Reference: http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
Question:
Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path to reach (m, n) from (0, 0).
Each cell of the matrix represents a cost to traverse through that cell. 
Total cost of a path to reach (m, n) is sum of all the costs on that path (including both source and destination). 
You can only traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed.
You may assume that all costs are positive integers.
*/
public class MinCostPathGraph {
    
    public static int minCostDP(int[][] graph, int x, int y) {
        // int[][] dp = new int[graph.length + 1][graph[0].length + 1];
        int[][] dp = new int[x+1][y+1];
        //seed 0,0 value since we start there.
        dp[0][0] = graph[0][0];
        //also first row and column since we build dp bottom up
        for(int i = 1; i <= x; i++)
            dp[i][0] = dp[i-1][0] + graph[i][0];
        for(int i = 1; i <= y; i++)
            dp[0][i] = dp[0][i-1] + graph[0][i];
        
        //since bottom up, the cost of a current cell is the previous + cost of the current cell.
        // different then the recursive one that is top down.
        //also note the <= instead of < since x and y are index postions.
        for(int i = 1; i <= x; i++) 
            for(int j = 1; j <= y; j++) 
                dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + graph[i][j];
        
        return dp[x][y];
    }
    
    //Recursive method
    public static int minCost(int[][] graph, int x, int y) {
        //need to handle case were we recurse past 0, use MAX_integer since that is never the min.
        if(x < 0 || y < 0) 
            return Integer.MAX_VALUE;
        else if(x == 0 && y == 0)
            return graph[x][y];
        else 
            return graph[x][y] + min(minCost(graph, x - 1, y),
                                     minCost(graph, x, y - 1),
                                     minCost(graph, x - 1, y - 1));
    }
    
    private static int min(int x, int y, int z) {
        if(x < y)
            return (x < z) ? x : z;
        else 
            return (y < z) ? y : z;
    }
    
    public static void main(String[] args) {
        int[][] graph = new int[][] { {1, 2, 3},
                                      {4, 8, 2},
                                      {1, 5, 3} };
        
        System.out.println("Min Cost is : " + minCostDP(graph, 2,2));
    }
}