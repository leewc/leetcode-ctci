public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      if(nums.length == 0 || k == 0) return new int[0];
      Deque<Integer> dq = new ArrayDeque<>();
      
      int len = nums.length;
      int[] result = new int[len - k + 1];
      int i_max = 0;
      for(int i = 0; i < len; i++) {
          if(!dq.isEmpty() && dq.peekFirst() < i - k + 1)
            dq.poll(); //aka pollFirst, or remove.
          
          while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
            dq.pollLast();
        
          dq.offer(i); //i is now a potential max in the dq. add it in
          
          if(i - k + 1 >= 0)
            result[i_max++] = nums[dq.peekFirst()];
      }
      return result;
    }

    //Same thing, different deque calls
    public int[] maxSlidingWindowUsingPollFirstAndLast(int[] nums, int k) {
        if(nums.length == 0 || k == 0)
            return nums;
        
        int len = nums.length;
        int max[] = new int[len - k + 1];
        int max_i = 0;
        //deque will hold indexes of possible maximums
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int i = 0; i < len; i++) {
            //remove indexes that are out of range
            if(!deque.isEmpty() && deque.peekFirst() < i - k + 1)
                deque.pollFirst();
                
            //remove indexes of values that cannot be the max
            //deque.peekLast() gives the index
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            
            deque.offerLast(i); //aka offer
            //add current value i into the deque, it is now the possible max.
            if(i >= k - 1)
                max[max_i++] = nums[deque.peekFirst()]; 
        }
        return max;
        
    }
}