package DynamicProgramming;

import java.util.Arrays;

/**
 * Created by Tien on 2/19/2018.
 *
 * https://leetcode.com/problems/perfect-squares/description/
 *
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class PerfectSquares279 {

    /**
     * DP
     * O(n*sqrt(n))
     * O(n) Time complexity
     *
     * dp[0] = 0
     * dp[1] = 1 + dp[1 - 1*1] = 1 - perfect square number
     * dp[2] = 1 + dp[1] = 2
     * dp[3] = 1 + dp[2] = 3
     * dp[4] = 1 + dp[4 - 2*2] = 1 - perfect square number
     * ....
     * dp[13] = 1 + dp[13 - 3*3] = 1 + dp[4] = 2
     * @param n
     * @return
     */
    int numSquares1(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; i - j*j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] +1);
            }
        }
        return dp[n];
    }

    /**
     * Lagrange's four-square theorem, also known as Bachet's conjecture, states that every natural number can be represented as the sum of four integer squares.
     * Legendre's three-square theorem states that a natural number can be represented as the sum of three squares of integers
     *      n = x^2 + y^2 + z^2
     * if and only if n is not of the form n = 4^a(8b + 7) for integers a and b.
     *
     * @param n
     * @return
     */
    int numSquares2(int n) {
        if(isSquareRoot(n)) return 1;

        //n /= 4
        while(n%4 == 0) {
            n >>= 2;
        }

        //Check if n is of the form n = 4^a(8b + 7)
        if(n%8 == 7) {
            return 4;
        }

        //Check if n can be written by sum of 2 square numbers
        for(int i = 1; i*i <=n ; i++) {
            if(isSquareRoot(n - i*i))
                return 2;
        }

        return 3;
    }

    boolean isSquareRoot(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
