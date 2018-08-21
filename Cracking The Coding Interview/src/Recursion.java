/**
 * Created by Tien on 8/19/2018.
 */
public class Recursion {

    /**
     * 8.1
     *
     * Recursion
     *
     * Time complexity: T(n) = T(n-1) + T(n-2) = O(2^n)
     * Space complexity: O(n)
     *
     * Write a method to generate the nth Fibonacci number.
     * @param n
     * @return
     */
    public int fibo1(int n) {
        if(n <= 1) {
            return n;
        } else {
            return fibo1(n-1) + fibo1(n-2);
        }
    }

    /**
     * 8.1
     *
     * Dynamic programming
     *
     * Write a method to generate the nth Fibonacci number.
     * @param n
     * @return
     */
    public int fibo2(int n) {
        if(n <= 1) return n;

        int[] f = new int[n+2];
        f[0] = 0;
        f[1] = 1;
        for(int i = 2; i <= n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    /**
     * 8.1
     *
     * Dynamic programming with optimized space
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * Write a method to generate the nth Fibonacci number.
     * @param n
     * @return
     */
    public int fibo3(int n) {
        if(n <= 1) return n;
        int f0 = 0, f1 = 1, f;
        for(int i = 2; i <= n; i++) {
            f = f0 + f1;
            f0 = f1;
            f1 = f;
        }
        return f1;
    }

    /**
     * 8.2
     *
     * Imagine a robot sitting on the upper left hand corner of an NxN grid. The robot can only move in two directions: right and down.
     * How many possible paths are there for the robot?
     *
     * FOLLOW UP:
     * Imagine certain squares are “off limits”, such that the robot can not step on them. Design an algorithm to get all possible paths for the robot.
     */

    /**
     * 8.2
     *
     * Recursion
     *
     * Time complexity: O(2^n)
     * Space complexity: O(2^n)
     *
     * @param x
     * @param y
     * @return
     */
    public int countPath1(int x, int y) {
        if(x == 1 || y == 1) {
            return 1;
        }
        return countPath1(x-1, y) + countPath1(x, y-1);
    }

    /**
     * 8.2
     *
     * Iteration
     *
     * Time complexity: O(x*y)
     * Space complexity: O(x*y)
     * @param x
     * @param y
     * @return
     */
    public int countPath2(int x, int y) {
        int[][] dp = new int[x][y];

        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[x-1][y-1];
    }

    /**
     * 8.2
     *
     * Iteration
     *
     * Time complexity: O(x*y)
     * Space complexity: O(y)
     * @param x
     * @param y
     * @return
     */
    public int countPath3(int x, int y) {
        int[] dp = new int[y];
        dp[0] = 1;
        for(int i = 0; i < x; i++) {
            for(int j = 1; j < y; j++) {
                dp[j] += dp[j-1];
            }
        }
        return dp[y-1];
    }

    public int countPath4(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int[][] dp = new int[x][y];

        for(int i = 0; i < x; i++) {
            if(grid[i][0] == 1) break;
            dp[i][0] = 1;
        }

        for(int j = 0; j < y; j++) {
            if(grid[0][j] == 1) break;
            dp[0][j] = 1;
        }

        for(int i = 1; i < x; i++) {
            for(int j = 1; j < y; j++) {
                if(grid[i][j] == 1) continue;
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[x-1][y-1];
    }
}
