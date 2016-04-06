public class Solution {
    //ref: http://www.cnblogs.com/springfor/p/3889222.html
    // http://blog.csdn.net/worldwindjp/article/details/21536103
    public List<Integer> grayCodeRECURSIVE(int n) {
        if(n == 0) {
            List<Integer> grey = new ArrayList<>();
            grey.add(0);
            return grey;
        }
        
        //else recurse down into base case
        List<Integer> grey = grayCodeRECURSIVE(n - 1);
        
        //add number
        // (1) prefix all the gray code with n-1 bits with 0
        // (2) reverse the order of the n-1 bit gray code and prefix all of them with 1 (reflected)
        // (3) concatenate (1) and (2) to get the gray code of n bits

        int num = 1 << (n - 1); //does step one and two
        // alternatively copy into a new result array: List<Integer> result = new ArrayList<>(grey);
        int original_size = grey.size();
        for(int i = original_size - 1; i >= 0; i--)
            grey.add(grey.get(i) + num); //step three, add to original number
        return grey;
    }
    
    //Iterative Soln
    public List<Integer> grayCode(int n) {
        List<Integer> grey = new ArrayList<>();
        grey.add(0);
        
        //start from 1 since first number is 1
        for(int i = 0; i < n; i++){
            int num = 1 << i;
            for(int j = grey.size() - 1; j >= 0; j--)
                grey.add(grey.get(j) + num);
        }
        return grey;
    }
}