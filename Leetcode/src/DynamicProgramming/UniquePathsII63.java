package DynamicProgramming;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 The robot can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 Now consider if some obstacles are added to the grids. How many unique paths would there be?
 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 Note: m and n will be at most 100.

 Example 1:
 Input:
 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 Output: 2
 Explanation:
 There is one obstacle in the middle of the 3x3 grid above.
 There are two ways to reach the bottom-right corner:
 1. Right -> Right -> Down -> Down
 2. Down -> Down -> Right -> Right


 *
 * Created by Tien on 8/22/2018.
 */
public class UniquePathsII63 {
    public int uniquePathsWithObstacles(int[][] grid) {
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
