//Ref : http://siyang2notleetcode.blogspot.com/2015/02/arithmetic-slice.html
//      https://gist.github.com/Linyes/10219849

public class ArithmeticSlices {
    
    public static int arithmeticSlice(int[] nums) {
        if(nums.length < 3) return 0;
        int n = nums.length;
        int start = 0;
        int totalSlices = 0; //answer we want
        
        while(start < n - 2) { //since a slice goes up to one number before
            int end = start + 1; 
            int diff = nums[end] - nums[start];
            
            while(end < n - 1 && nums[end + 1] - nums[end] == diff)
                end++;
            
            int lenOfSlice = end - start + 1;
            
            if(lenOfSlice >= 3) {
                //For an arithmetic progression with length n, where n>3, the number of slices it can form is
				// (n-2)*(n-1)/2. For example, if n = 5, it has 3 slices with length 3, 2 slices with length 4, 
				// and 1 slice with length 5. (taken from the gist by Linyes)
                totalSlices += (lenOfSlice - 1) * (lenOfSlice - 2) / 2;
                
            }
            start = end; //advance start to end since arithmetic progress does not overlap.
        }
        return totalSlices;
    }
    
    public static void main(String[] args) {
        int[] nums = {-1, 1, 3, 3, 3, 2, 1, 0};
        System.out.println("No. of Arithmetic Slices: " + arithmeticSlice(nums));
    }
    
}