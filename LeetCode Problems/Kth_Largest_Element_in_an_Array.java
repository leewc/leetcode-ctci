public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        // if(len == 0) return 0; //we get to assume k is always valid
        Queue<Integer> pq = new PriorityQueue(nums.length,
                                    new Comparator<Integer>(){ 
                                            public int compare(Integer a, Integer b) {
                                                return Integer.compare(b, a);
                                            }
                                    });
        for(int num : nums)
            pq.offer(num);
        
        int kth = 0;
        for(int i = 0; i < k; i++)
            kth = pq.poll();
        
        return kth;
    }
}