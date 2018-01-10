package DFSandBFS;

/**
 * Created by Tien on 1/10/2018.
 *
 *https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
 *
 * Given an integer matrix, find the length of the longest increasing path.

 From each cell, you can either move to four directions: left, right, up or down.
 You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

 Example 1:

 nums = [
 [9,9,4],
 [6,6,8],
 [2,1,1]
 ]
 Return 4
 The longest increasing path is [1, 2, 6, 9].

 Example 2:

 nums = [
 [3,4,5],
 [3,2,6],
 [2,2,1]
 ]
 Return 4
 The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
public class LongestIncreasingPathInMatrix329 {

    /**
     * DFS and Dynamic Programming
     * O(mn) Time complexity - visit each node once
     * O(mn) Space - DP 2D array - store max length can reach from that node
     * If length of node n is found and n.value is less than next nodes, we don't need to find it again during the
     * recursive calls since its value is stored in DP array
     * @param matrix
     * @return
     */
    int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dp[i][j] == 0) {
                    max = Math.max(max, dfs(matrix, dp, Integer.MIN_VALUE, i, j));
                }
            }
        }
        return max;
    }

    int dfs(int[][] matrix, int[][] dp, int min, int i, int j) {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= min)
            return 0;

        if(dp[i][j] != 0)
            return dp[i][j];

        int a = 1 + dfs(matrix, dp, matrix[i][j], i-1, j);
        int b = 1 + dfs(matrix, dp, matrix[i][j], i+1, j);
        int c = 1 + dfs(matrix, dp, matrix[i][j], i, j-1);
        int d = 1 + dfs(matrix, dp, matrix[i][j], i, j+1);

        int max = Math.max(a, Math.max(b, Math.max(c, d)));
        dp[i][j] = max;
        return max;
    }
}
