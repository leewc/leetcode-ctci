public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //process the matrix as flat array and run binary search 
        int N = matrix[0].length * matrix.length;
        int low = 0;
        int high = N - 1;
        
        while(low != high) {
            int mid = low + (high - low) /2;
            
            //translate back into 2D matrix index
            int x = (mid / matrix[0].length);
            int y = (mid % matrix[0].length);
            
            if(matrix[x][y] >= target) //loop ends with high = mid if we found target
                high = mid;
            else
                low = mid + 1;
        }
        return matrix[(high / matrix[0].length)][(high % matrix[0].length)] == target;
        
    }
    
    
    public boolean searchMatrixStepWise(int[][] matrix, int target) {
        int lenx = matrix.length;
        int leny = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[lenx - 1][leny - 1]) 
            return false;
            
        //start from top right (since it's the largest in row 1)
        int x = lenx - 1;
        int y = 0;
        while(x >= 0 && y < leny) {
            if(matrix[x][y] > target)       //move left
                x--;
            else if(matrix[x][y] < target)  //move down 
                y++;
            else                            //found the target
                return true;
        }
        return false;
    }
}