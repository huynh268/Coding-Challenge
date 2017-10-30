/**
 * Created by Tien on 10/29/2017.
 */
public class coinChange322 {

    /**
     * You are given coins of different denominations and a total amount of money amount.
     * Write a function to compute the fewest number of coins that you need to make up that amount.
     * If that amount of money cannot be made up by any combination of the coins, return -1.

     Example 1:
     coins = [1, 2, 5], amount = 11
     return 3 (11 = 5 + 5 + 1)

     Example 2:
     coins = [2], amount = 3
     return -1.
     */

    //O(m*n) Complexity - O(m*n) Space
    public static int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;

        int dp[][] = new int[coins.length+1][amount+1];

        for(int i = 0; i < amount+1; i++) {
            dp[0][i] = Integer.MAX_VALUE-1;
        }

        for(int i = 1; i < coins.length+1; i++) {
            for(int j = 1; j < amount+1; j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]] + 1);
                }
            }
        }

        for (int i = 0; i < coins.length+1; i++) {
            for (int j = 0; j < amount+1; j++) {
                System.out.printf("%4d",dp[i][j]);
            }
            System.out.println();
        }

        return dp[coins.length][amount] > amount ? -1 : dp[coins.length][amount];
    }

    public static void main(String[] args) {
        System.out.println("coins = [1,2,5], amount = 11: "+coinChange(new int[] {1,2,5}, 11));
    }
}
