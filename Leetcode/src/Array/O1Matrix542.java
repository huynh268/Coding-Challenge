package Array;

import java.util.Arrays;

/**
 * Created by Tien on 3/9/2018.
 *
 * https://leetcode.com/problems/01-matrix/description/
 *
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell. The distance between two adjacent cells is 1.

 Example 1:
 Input:
 0 0 0
 0 1 0
 0 0 0
 Output:
 0 0 0
 0 1 0
 0 0 0


 Example 2:
 Input:
 0 0 0
 0 1 0
 1 1 1
 Output:
 0 0 0
 0 1 0
 1 2 1


 Note:
 The number of elements of the given matrix will not exceed 10,000.
 There are at least one 0 in the given matrix.
 The cells are adjacent in only four directions: up, down, left and right.
 */
public class O1Matrix542 {

    /**
     * Dynamic Programming
     * O(m*n) Time complexity
     * O(m*n) Space
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return matrix;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 10000);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if(i > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + 1);
                    }
                    if(j > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + 1);
                    }
                }
            }
        }


        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                if(i < m-1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i+1][j] + 1);
                }
                if(j < n-1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j+1] + 1);
                }
            }
        }

        return dp;
    }
}
