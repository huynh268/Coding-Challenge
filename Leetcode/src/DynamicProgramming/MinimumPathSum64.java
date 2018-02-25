package DynamicProgramming;

/**
 * Created by Tien on 2/24/2018.
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.

 Example 1:
 [[1,3,1],
 [1,5,1],
 [4,2,1]]
 Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum64 {

    /**
     * DP
     * O(n^2) Time complexity
     * O(1) Space
     * @param grid
     * @return
     */
    int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(i == 0 && j == 0) { //grid[0][0] - First move
                    grid[i][j] = grid[i][j];
                } else if (i == 0) { //First row, can only move right
                    grid[i][j] = grid[i][j] + grid[i][j-1]; //Check the previous move - left
                } else if (j == 0) { //First col, can only move down
                    grid[i][j] = grid[i][j] + grid[i-1][j]; //Check the previous move - up
                } else { //Can move both right or down, find minimum value of the previous moves - up and left
                    grid[i][j] = grid[i][j] + Math.min(grid[i][j-1], grid[i-1][j]);
                }
            }
        }

        return grid[row - 1][col - 1];
    }
}
