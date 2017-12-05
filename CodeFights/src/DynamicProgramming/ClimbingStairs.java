package DynamicProgramming;

/**
 * Created by Tien on 12/4/2017.
 */
public class ClimbingStairs {

    //DP O(n) time complexity -  O(n) space
    int climbingStairs1(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++)
            dp[i] = dp[i-1] + dp[i-2];

        return dp[n];
    }

    //DP O(n) time complexity -  O(1) space
    int climbingStairs2(int n) {
        if(n <= 2) return n;

        int a = 1, b = 1, c = 0;
        for(int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    //Recursion exponential time complexity O(2^n) - O(n) = O(recursion depth) space
    int climbingStairs3(int n) {
        if(n == 1)
            return 1;
        else if(n == 2)
            return 2;
        else
            return climbingStairs3(n-1) + climbingStairs3(n-2);
    }
}
