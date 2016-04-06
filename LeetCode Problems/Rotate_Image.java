public class Solution {
    public void rotate(int[][] matrix) {
        for(int layer = 0; layer < matrix.length / 2; layer++) {
            int first = layer;
            int last = matrix.length - layer - 1;
            for(int i = first; i < last; i++){
                int offset = i - first;
                //copy top
                int top = matrix[first][i]; 
                //copy left -> top 
                matrix[first][i] = matrix[last - offset][first];
                //copy bottom -> left
                matrix[last-offset][first] = matrix[last][last-offset];
                //copy right -> bottom
                matrix[last][last-offset] = matrix[i][last];
                //copy top -> right
                matrix[i][last] = top;
            }
        }
    }
    
    // This was from Cracking the coding interview.
    public void rotateCTCI(int[][] matrix) {
        for(int layer = 0; layer < matrix.length / 2; layer++) {
            int first = layer;
            int last = matrix.length - layer - 1;
            for(int i = first; i < last; i++) {
                int offset = i - first;
                //save top
                int temp = matrix[first][i];
                //copy left -> top
                matrix[first][i] = matrix[last - offset][first];
                //copy bottom -> left
                matrix[last - offset][first] = matrix[last][last-offset];
                //copy right -> bottom
                matrix[last][last-offset] = matrix[i][last];
                //copy top -> right
                matrix[i][last] = temp;
            }
        }
    }
}