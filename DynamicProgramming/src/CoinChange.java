import java.util.Arrays;

/**
 * Created by Tien on 10/26/2017.
 */
public class CoinChange {

    public static int coinChangeNumberOfWays(int[] coins, int total) {
        int[][] dp = new int[coins.length+1][total+1];

        for(int i = 0; i < coins.length+1; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i < coins.length+1; i++) {
            for(int j = 1; j < total+1; j++) {
                if(coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        System.out.print("    ");
        for (int j = 0; j < total+1; j++) {

            System.out.printf("%4d", j);
        }
        System.out.println();
        for(int i = 1; i < coins.length+1; i++){
            System.out.printf("%4d", coins[i-1]);
            for (int j = 0; j < total+1; j++) {
                System.out.printf("%4d", dp[i][j]);
            }
            System.out.println();
        }
        return dp[coins.length][total];
    }

    public static int coinChangeNumberOfWays2(int[] coins, int total) {
        int[] dp = new int[total+1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for(int j = 1; j < total+1; j++) {
                if(coins[i] <= j) {
                    dp[j] += dp[j-coins[i]];
                }
            }
        }

        
        for (int j = 0; j < total+1; j++) {

            System.out.printf("%4d", j);
        }
        System.out.println();

        for (int i = 0; i < total+1; i++) {
            System.out.printf("%4d", dp[i]);
        }
        System.out.println();

        return dp[total];
    }


    public static void main(String[] args) {
        System.out.println("coins [3,4,5,6,7,9], total 15: "+ coinChangeNumberOfWays(new int[]{3,4,5,6,7,9}, 15));
        System.out.println();
        System.out.println("coins [3,4,5,6,7,9], total 15: "+ coinChangeNumberOfWays2(new int[]{3,4,5,6,7,9}, 15));
    }
}
