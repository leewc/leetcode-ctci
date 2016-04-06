public class Solution {
    //constraints: only buy and sell one share of the stock
    //must buy before selling --hence we can't just keep track of min max values.
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        //index for min -- we use this to keep track of the min constantly
        // but also keep track of maxProfit separately;
        int min = 0;
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < prices[min])
                min = i;
            if(prices[i] - prices[min] > maxProfit)
                maxProfit = prices[i] - prices[min];
        }
        //invariant: maxProfit always holds the max profit in the array, which might have been from a different min val
        // since we may find a late smaller min value later.
        return maxProfit;
    }
    
    //Test cases:
    // []
    // [1, 2, 10, 5]
    // [5,5,5,1,0]
    // [10, -5, 1, 15]
    // [2, 1]
    // [3,3,5,0,0,3,1,4]

    // doesn't work for cases where there is a better min after a max: 3 3 5 0 0 3 1 4 
    // public int maxProfit(int[] prices) {
    //     if(prices.length < 2) return 0;
    //     //indexes for min/max;
    //     int min = 0;
    //     int max = prices.length - 1;
    //     for(int i = 0; i < prices.length; i++) {
    //         // must buy first (i < max)
    //         // check if better buy time
    //         if((prices[max] - prices[i] > prices[max] - prices[min]) && i < max)
    //             min = i;
    //         else if(prices[i] - prices[min] > prices[max] - prices[min] && i >= min) // also needs >= to ensure minmax is updated for cases like [2, 1]
    //             max = i;
    //     }
    //     return prices[max] - prices[min];
    // }
}