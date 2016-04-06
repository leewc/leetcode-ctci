public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // attempt to sort from the end to the front in-place
        int idxFirst = m - 1;
        int idxSecond = n - 1;
        
        int cur = m+n-1; //since nums1 has enough space we start from the end
        
        if(n == 0)
            return;
        
        while(idxFirst >= 0 && idxSecond >= 0 && cur >= 0)
        {
            if(nums1[idxFirst] >= nums2[idxSecond]) //case: item in nums1 is larger
            {
                nums1[cur] = nums1[idxFirst];
                idxFirst--;
                cur--;
            }
            else //case: item in nums2 is larger
            {
                nums1[cur] = nums2[idxSecond];
                idxSecond--;
                cur--;
            }
        }
        
        //  if(idxFirst >= 0)
        //  {
        //   System.arraycopy(nums1, 0, nums1, cur, m - idxFirst);
        //   cur += m - idxFirst;
        //  }
         if(idxSecond >= 0)
         {
            System.arraycopy(nums2,0, nums1, 0, cur+1); //last argument asks for length, not index. - Miao Yu
            cur += n - idxSecond;
         }
        // while(idxFirst >= 0)
        // {
        //     nums1[cur] = nums1[idxFirst];
        //     idxFirst--;
        //     cur--;
        // }
        // while(idxSecond >= 0)
        // {
        //     nums1[cur] = nums2[idxSecond];
        //     idxSecond--;
        //     cur--;
        // }
    }
}