/**
 * Created by Tien on 10/25/2017.
 */
public class EggDropping {

    public static int eggDropping(int egg, int floor) {
        int[][] dp = new int[egg+1][floor+1];

        //initialize base case: at floor 0 and floor 1
        for(int i = 1 ; i < egg+1; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        //initialize base case: 1 egg - test n drops for n floors
        for(int i = 1; i < floor+1; i++) {
            dp[1][i] = i;
        }

        int min;
        for(int i = 2; i < egg+1; i++){
            for(int j = 1; j < floor+1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for(int m = 1; m <= j; m++) {
                    min = 1+ Math.max(dp[i-1][m-1], dp[i][j-m]);
                    if(min < dp[i][j]) {
                        dp[i][j] = min;
                    }
                }
            }
        }
        return dp[egg][floor];
    }

    public static void main(String[] args) {
        System.out.println("2 eggs, 100 floors: "+eggDropping(2,100));
        System.out.println("2 eggs, 36 floors: "+eggDropping(2,36));
        System.out.println("2 eggs, 1000 floors: "+eggDropping(2,1000));
    }
}
