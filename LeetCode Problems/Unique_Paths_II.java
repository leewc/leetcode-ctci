public class Solution {
    
    public int uniquePathsWithObstacles(int[][] grid) {
        int height = grid[0].length;
        int[] dp = new int[height]; //dp[x] will be the total number of paths to col x in the current row
        dp[0] = 1;
        //scan paths from left to right
        for(int[] column : grid) {
            //iterate from top to bottom of each column
            for(int i = 0; i < height; i++) {
                if(column[i] == 1)
                    dp[i] = 0; //obstacle, 0 paths to get here.
                else if(i > 0)
                    dp[i] += dp[i-1];
            }
        }
        return dp[height - 1];
    }
    
    //This is correct but fails the time limit set by leetcode
    public int uniquePathsWithObstaclesBreadthFirstSearch(int[][] grid) {
        int lenx = grid.length;
        int leny = grid[0].length;
        
        boolean[][] visited = new boolean[lenx][leny];
        Queue<Point> q = new LinkedList<>();
        int uniquePath = 0;
        
        q.offer(new Point(0,0));
        visited[0][0] = true;
        while(!q.isEmpty()) {
            Point p = q.poll();
            if(p.x == lenx - 1 && p.y == leny - 1) //found endpoint, stop. 
                uniquePath++;
            else { //9,9 will never be marked visited
                visited[p.x][p.y] = true;
                //add next possible coordinates
                //bounds check and see if visited before and if it's not an obstacle
                // can move this into another function but need to pass visited and grid
                //left
                if(p.x - 1 > 0 && !visited[p.x - 1][p.y] && grid[p.x - 1][p.y] != 1)
                    q.offer(new Point(p.x - 1, p.y));
                //right
                if(p.x + 1 < lenx && !visited[p.x + 1][p.y] && grid[p.x + 1][p.y] != 1)
                    q.offer(new Point(p.x + 1, p.y));
                //up
                if(p.y - 1 > 0 && !visited[p.x][p.y - 1] && grid[p.x][p.y - 1] != 1)
                    q.offer(new Point(p.x, p.y - 1));
                //down 
                if(p.y + 1 < leny && !visited[p.x][p.y + 1] && grid[p.x][p.y + 1] != 1)
                    q.offer(new Point(p.x, p.y + 1));
            }
        }
        return uniquePath;
    }
}

class Point {
    int x;
    int y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}