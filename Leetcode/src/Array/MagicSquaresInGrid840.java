package Array;

/**
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
 Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).

 Example 1:
 Input: [[4,3,8,4],
 [9,5,1,9],
 [2,7,6,2]]
 Output: 1

 Explanation:
 The following subgrid is a 3 x 3 magic square:
 438
 951
 276

 while this one is not:
 384
 519
 762

 In total, there is only one magic square inside the given grid.

 Note:
 1 <= grid.length <= 10
 1 <= grid[0].length <= 10
 0 <= grid[i][j] <= 15

 */
public class MagicSquaresInGrid840 {

    /**
     * O(R*C) Time complexity
     * O(1) Space
     * @param grid
     * @return
     */
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length-2; i++) {
            for(int j = 0; j < grid[0].length-2; j++) {
                if(check(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean check(int[][] g, int i, int j) {
        int[] count = new int[10];
        for(int a = i; a < i+3; a++) {
            for(int b = j; b < j+3; b++) {
                if(g[a][b] > 9 || g[a][b] < 1) return false;
                count[g[a][b]] ++;
                if(count[g[a][b]] > 1) return false;
            }
        }

        return g[i][j] + g[i][j+1] + g[i][j+2] == 15 &&
                g[i+1][j] + g[i+1][j+1] + g[i+1][j+2] == 15 &&
                g[i+2][j] + g[i+2][j+1] + g[i+2][j+2] == 15 &&
                g[i][j] + g[i+1][j] + g[i+2][j] == 15 &&
                g[i][j+1] + g[i+1][j+1] + g[i+2][j+1] == 15 &&
                g[i][j] + g[i+1][j+1] + g[i+2][j+2] == 15 &&
                g[i][j+2] + g[i+1][j+1] + g[i+2][j] == 15;
    }
}
