package DynamicProgramming;

/**
 * Created by Tien on 2/24/2018.
 *
 * https://leetcode.com/problems/unique-paths/description/
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?
 */
public class UniquePaths62 {

    /**
     * DP
     * O(n*m) Time complexity
     * O(n*m) Space
     * @param m
     * @param n
     * @return
     */
    int uniquePaths1(int m, int n) {
        int[][] grid = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
            }
        }
        return grid[m-1][n-1];
    }

    /**
     * DP
     * O(n*m) Time complexity
     * O(n) Space
     * @param m
     * @param n
     * @return
     */
    int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }


}
