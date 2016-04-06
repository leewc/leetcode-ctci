// [1]
// 0
// [1, 2, 5]
// 11
// [1, 2, 5]
// 6
// [2]
// 1
// Good explanation if we also want to print the coins: https://www.youtube.com/watch?v=NJuKJ8sasGk
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] change = new int[amount + 1]; //holds the optimal number of coins for each sum
        int sum = 1; //start at sum 1
        int[] coinSet = new int[amount + 1]; //holds the coins we used. a lookup table for all combo of coins

        while(sum <= amount) {
            int min = -1;
            //iterate through all coins to find the min for this sum
            for(int coin : coins) {

                if(coin <= sum && change[sum - coin] != -1) { //-1 check for invalid counts.
                    int possible = change[sum - coin] + 1;
                    //logic used to set minimum
                    if(min < 0) {
                        min = possible;
                        coinSet[sum] = coin;
                    }
                    else if(possible < min) {
                        min = possible;
                        coinSet[sum] = coin;
                    }
                }

            }
            change[sum] = min;
            sum++;
        }
        
        //We can get the coins we need to use by storing which coin was used for that particular sum
        //Then we can get the next coin to use by deducting amount (aka coinSet.length) from the sum.
        if(change[amount] != -1) {
            for(int i = amount; i > 0;) {
                // System.out.println("Use Coin: " + coinSet[i]);
                i = i - coinSet[i];
            }
        }
        // System.out.println("");
        return change[amount];
    }


    //Method for just printing the minimum number of coins we need w/o tracking which to use
    public int coinChange2(int[] coins, int amount) {
        int[] change = new int[amount + 1]; //holds the optimal number of coins for each sum
        int sum = 1; //start at sum 1

        while(sum <= amount) {
            int min = -1;
            //iterate through all coins to find the min for this sum
            for(int coin : coins) {

                if(coin <= sum && change[sum - coin] != -1) { //-1 check for invalid counts.
                    int possible = change[sum - coin] + 1;
                    //logic used to set minimum
                    if(min < 0)
                        min = possible;
                    else if(possible < min)
                        min = possible;
                }

            }
            change[sum] = min;
            sum++;
        }
        return change[amount];
    }
}