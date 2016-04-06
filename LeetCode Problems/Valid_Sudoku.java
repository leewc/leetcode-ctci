public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] occurs = new boolean[9];
        
        //check rows
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                int val = board[i][j] - '1';
                if(board[i][j] == '.')
                    continue;
                else if(occurs[val] == false)
                    occurs[val] = true;
                else
                    return false;
            }
            Arrays.fill(occurs, false);
        }
        
        //check cols 
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                int val = board[j][i] - '1';
                if(board[j][i] == '.')
                    continue;
                else if(occurs[val] == false)
                    occurs[val] = true;
                else
                    return false;
            }
            Arrays.fill(occurs, false);
        }
        
        //check sub cols
        for(int k = 0; k < 9; k += 3) {
            for(int l = 0; l < 9; l += 3) {            
                for(int i = 0; i < 3; i++) {
                    for(int j = 0; j < 3; j++)
                    {
                        int val = board[k+i][l+j] - '1';
                        if(board[k+i][l+j] == '.')
                            continue;
                        else if(occurs[val] == false)
                            occurs[val] = true;
                        else 
                            return false;
                    }
                }
            Arrays.fill(occurs, false);
            }
        }
        
        return true;
        
    }
}