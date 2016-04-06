public class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                //first conditional helps with short circuit
                if(word.charAt(0) == board[i][j] && dfs(board, visited, word, i, j, 0)) //start comparing at index 1 since 0 is a match
                    return true;
            }
        }
        return false;
    }
    
    //where int i, int j are the starting point in a board we want to check and it's adjacents
    //index is the index of the word we're at
    private boolean dfs(char[][] board, boolean[][] visited, String word, int i, int j, int index) {
        if(index == word.length()) //all match!
            return true;
            
        //bounds check & if we've visited
        if(i < 0  || i >= board.length || j < 0 || j >= board[0].length || visited[i][j])
            return false;

        visited[i][j] = true;
        // ensure valid char, and recursion (can move valid char up to the bounds check too)
        if( word.charAt(index) == board[i][j] && 
            (  dfs(board, visited, word, i+1, j, index + 1) 
            || dfs(board, visited, word, i, j + 1, index + 1)
            || dfs(board, visited, word, i-1, j, index + 1)
            || dfs(board, visited, word, i, j - 1, index + 1)
            ))
            return true;
        
        //else restore unvisited state, backtrack
        visited[i][j] = false;
        return false;
    }
}